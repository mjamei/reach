package edu.arizona.sista.reach.grounding

import com.typesafe.config.ConfigFactory

import edu.arizona.sista.odin._
import edu.arizona.sista.reach._
import edu.arizona.sista.reach.mentions._

/**
  * Class which implements project internal methods to ground entities.
  *   Written by Tom Hicks. 11/9/2015.
  *   Last Modified: Remove aux grounding.
  */
class ReachGrounder extends DarpaFlow {

  /** An exception in case we somehow fail to assign an ID during resolution. */
  case class NoFailSafe(message:String) extends Exception(message)

  // Read config file to determine whether to include knowledge bases
  val config = ConfigFactory.load()

  /** Project local sequence for resolving entities: check local facade KBs in this order:
    * 2. Protein Families
    * 3. Proteins
    * 4. Small Molecules (metabolites and chemicals)
    * 5. Subcellular Locations
    * 6. AZ Failsafe KB (failsafe: always generates an ID in a non-official, local namespace)
    */
  protected val searchSequence =
    Seq(
      new StaticProteinFamilyKBML,
      new ManualProteinFamilyKBML,
      new StaticProteinKBML,
      new ManualProteinKBML,
      // NB: generated protein families are included in the generated protein KB:
      new GendProteinKBML,

      new StaticChemicalKBML,
      new StaticMetaboliteKBML,
      new ManualChemicalKBML,
      new GendChemicalKBML,

      new StaticCellLocationKBML,
      new ManualCellLocationKBML,
      new GendCellLocationKBML,

      new ContextCellTypeKBML,
      new ContextSpeciesKBML,
      new ContextCellLineKBML,
      new ContextOrganKBML,
      new StaticTissueTypeKBML,

      new AzFailsafeKBML
    )

  /** Local implementation of darpa flow trait: use project specific KBs to ground
      and augment given mentions. */
  def apply (mentions: Seq[Mention], state: State): Seq[Mention] = mentions map {
    case tm: BioTextBoundMention => resolveAndAugment(tm, state)
    case m => m
  }

  /** Search the KB accessors in sequence, use the first one which resolves the given mention. */
  private def resolveAndAugment(mention: BioMention, state: State): Mention = {
    searchSequence.foreach { kbml =>
      // There may be more than one entry returned in the set, so just take any one, for now:
      val resolution = kbml.resolve(mention).flatMap(kbeset => kbeset.headOption)
      if (!resolution.isEmpty) {
        mention.ground(resolution.get.namespace, resolution.get.id)
        return mention
      }
    }
    // we should never get here because our accessors include a failsafe ID assignment
    throw NoFailSafe(s"ReachGrounder failed to assign an ID to ${mention.displayLabel} '${mention.text}' in S${mention.sentence}")
  }

}
