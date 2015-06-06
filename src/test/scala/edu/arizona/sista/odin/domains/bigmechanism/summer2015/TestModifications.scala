package edu.arizona.sista.odin.domains.bigmechanism.summer2015

import edu.arizona.sista.bionlp.mentions._
import org.scalatest._
import TestUtils._

/**
 * Unit tests to ensure PTM rules are matching correctly
 */
class TestModifications extends FlatSpec with Matchers {
  val docId = "testdoc"
  val chunkId = "1"

  // Ubiquitinated
  val ubiqJJ = "The ubiquitinated Ras binds AKT and ASPP2."
  val ubiqJJWithSite = "The ubiquitinated Ras at Ser16 binds AKT and ASPP2."
  val ubiqJJIntercedingWithSite = "The ubiquitinated Ras protein at Ser16 binds AKT and ASPP2."
  val ubiqVBN = "Ubiquitinated Ras binds AKT and ASPP2."
  val ubiqVBNWithSite = "Ubiquitinated Ras at Ser16 binds AKT and ASPP2."
  val ubiqVBNIntercedingWithSite = "Ubiquitinated Ras proteins at Ser16 binds AKT and ASPP2."
  // Phosphorylated
  val phosJJ = "The phosphorylated Ras binds AKT and ASPP2."
  val phosJJWithSite = "The phosphorylated Ras at Ser16 binds AKT and ASPP2."
  val phosJJIntercedingWithSite = "The phosphorylated Ras protein at Ser16 binds AKT and ASPP2."
  val phosVBN = "Phosphorylated Ras binds AKT and ASPP2."
  val phosVBNWithSite = "Phosphorylated Ras at Ser16 binds AKT and ASPP2."
  val phosVBNIntercedingWithSite = "Phosphorylated Ras proteins at Ser16 binds AKT and ASPP2."
  // Farnesylated
  val farneJJ = "The farnesylated Ras binds AKT and ASPP2."
  val farneJJWithSite = "The farnesylated Ras at Ser16 binds AKT and ASPP2."
  val farneJJIntercedingWithSite = "The farnesylated Ras protein at Ser16 binds AKT and ASPP2."
  val farneVBN = "Farnesylated Ras binds AKT and ASPP2."
  val farneVBNWithSite = "Farnesylated Ras at Ser16 binds AKT and ASPP2."
  val farneVBNIntercedingWithSite = "Farnesylated Ras proteins at Ser16 binds AKT and ASPP2."
  // Ribosylated
  val riboJJ = "The ribosylated Ras binds AKT and ASPP2."
  val riboJJWithSite = "The ribosylated Ras at Ser16 binds AKT and ASPP2."
  val riboJJIntercedingWithSite = "The ribosylated Ras protein at Ser16 binds AKT and ASPP2."
  val riboVBN = "Ribosylated Ras binds AKT and ASPP2."
  val riboVBNWithSite = "Ribosylated Ras at Ser16 binds AKT and ASPP2."
  val riboVBNIntercedingWithSite = "Ribosylated Ras proteins at Ser16 binds AKT and ASPP2."
  // Hydroxylated
  val hydroxJJ = "The hydroxylated Ras binds AKT and ASPP2."
  val hydroxJJWithSite = "The hydroxylated Ras at Ser16 binds AKT and ASPP2."
  val hydroxJJIntercedingWithSite = "The hydroxylated Ras protein at Ser16 binds AKT and ASPP2."
  val hydroxVBN = "Hydroxylated Ras binds AKT and ASPP2."
  val hydroxVBNWithSite = "Hydroxylated Ras at Ser16 binds AKT and ASPP2."
  val hydroxVBNIntercedingWithSite = "Hydroxylated Ras proteins at Ser16 binds AKT and ASPP2."
  // Acetylated
  val aceJJ = "The acetylated Ras binds AKT and ASPP2."
  val aceJJWithSite = "The acetylated Ras at Ser16 binds AKT and ASPP2."
  val aceJJIntercedingWithSite = "The acetylated Ras protein at Ser16 binds AKT and ASPP2."
  val aceVBN = "Acetylated Ras binds AKT and ASPP2."
  val aceVBNWithSite = "Acetylated Ras at Ser16 binds AKT and ASPP2."
  val aceVBNIntercedingWithSite = "Acetylated Ras proteins at Ser16 binds AKT and ASPP2."
  // Glycosylated
  val glycoJJ = "The glycosylated Ras binds AKT and ASPP2."
  val glycoJJWithSite = "The glycosylated Ras at Ser16 binds AKT and ASPP2."
  val glycoJJIntercedingWithSite = "The glycosylated Ras protein at Ser16 binds AKT and ASPP2."
  val glycoVBN = "Glycosylated Ras binds AKT and ASPP2."
  val glycoVBNWithSite = "Glycosylated Ras at Ser16 binds AKT and ASPP2."
  val glycoVBNIntercedingWithSite = "Glycosylated Ras proteins at Ser16 binds AKT and ASPP2."
  // Methylated
  val methJJ = "The methylated Ras binds AKT and ASPP2."
  val methJJWithSite = "The methylated Ras at Ser16 binds AKT and ASPP2."
  val methJJIntercedingWithSite = "The methylated Ras protein at Ser16 binds AKT and ASPP2."
  val methVBN = "Methylated Ras binds AKT and ASPP2."
  val methVBNWithSite = "Methylated Ras at Ser16 binds AKT and ASPP2."
  val methVBNIntercedingWithSite = "Methylated Ras proteins at Ser16 binds AKT and ASPP2."
  // Sumoylated
  val sumoJJ = "The sumoylated Ras binds AKT and ASPP2."
  val sumoJJWithSite = "The sumoylated Ras at Ser16 binds AKT and ASPP2."
  val sumoJJIntercedingWithSite = "The sumoylated Ras protein at Ser16 binds AKT and ASPP2."
  val sumoVBN = "Sumoylated Ras binds AKT and ASPP2."
  val sumoVBNWithSite = "Sumoylated Ras at Ser16 binds AKT and ASPP2."
  val sumoVBNIntercedingWithSite = "Sumoylated Ras proteins at Ser16 binds AKT and ASPP2."

  ubiqJJ should "contain a ubiq PTM" in {
    val doc = testReach.mkDoc(ubiqJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }
  ubiqVBN should "contain a ubiq PTM" in {
    val doc = testReach.mkDoc(ubiqVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }
  ubiqJJWithSite should "contain a ubiq PTM with a site" in {
    val doc = testReach.mkDoc(ubiqJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }
  ubiqJJIntercedingWithSite should "contain a ubiq PTM with a site" in {
    val doc = testReach.mkDoc(ubiqJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }
  ubiqVBNWithSite should "contain a ubiq PTM with a site" in {
    val doc = testReach.mkDoc(ubiqVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }
  ubiqVBNIntercedingWithSite should "contain a ubiq PTM with a site" in {
    val doc = testReach.mkDoc(ubiqVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }

  phosJJ should "contain a phos PTM" in {
    val doc = testReach.mkDoc(phosJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "phosphorylated" should be (true)
  }
  phosVBN should "contain a phos PTM" in {
    val doc = testReach.mkDoc(phosVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "phosphorylated" should be (true)
  }
  phosJJWithSite should "contain a phos PTM with a site" in {
    val doc = testReach.mkDoc(phosJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "phosphorylated" should be (true)
  }
  phosJJIntercedingWithSite should "contain a phos PTM with a site" in {
    val doc = testReach.mkDoc(phosJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "phosphorylated" should be (true)
  }
  phosVBNWithSite should "contain a phos PTM with a site" in {
    val doc = testReach.mkDoc(phosVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "phosphorylated" should be (true)
  }
  phosVBNIntercedingWithSite should "contain a phos PTM with a site" in {
    val doc = testReach.mkDoc(phosVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "phosphorylated" should be (true)
  }

  farneJJ should "contain a farne PTM" in {
    val doc = testReach.mkDoc(farneJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "farnesylated" should be (true)
  }
  farneVBN should "contain a farne PTM" in {
    val doc = testReach.mkDoc(farneVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "farnesylated" should be (true)
  }
  farneJJWithSite should "contain a farne PTM with a site" in {
    val doc = testReach.mkDoc(farneJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "farnesylated" should be (true)
  }
  farneJJIntercedingWithSite should "contain a farne PTM with a site" in {
    val doc = testReach.mkDoc(farneJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "farnesylated" should be (true)
  }
  farneVBNWithSite should "contain a farne PTM with a site" in {
    val doc = testReach.mkDoc(farneVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "farnesylated" should be (true)
  }
  farneVBNIntercedingWithSite should "contain a farne PTM with a site" in {
    val doc = testReach.mkDoc(farneVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "farnesylated" should be (true)
  }

  riboJJ should "contain a ribo PTM" in {
    val doc = testReach.mkDoc(riboJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ribosylated" should be (true)
  }
  riboVBN should "contain a ribo PTM" in {
    val doc = testReach.mkDoc(riboVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ribosylated" should be (true)
  }
  riboJJWithSite should "contain a ribo PTM with a site" in {
    val doc = testReach.mkDoc(riboJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ribosylated" should be (true)
  }
  riboJJIntercedingWithSite should "contain a ribo PTM with a site" in {
    val doc = testReach.mkDoc(riboJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ribosylated" should be (true)
  }
  riboVBNWithSite should "contain a ribo PTM with a site" in {
    val doc = testReach.mkDoc(riboVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ribosylated" should be (true)
  }
  riboVBNIntercedingWithSite should "contain a ribo PTM with a site" in {
    val doc = testReach.mkDoc(riboVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ribosylated" should be (true)
  }

  hydroxJJ should "contain a hydrox PTM" in {
    val doc = testReach.mkDoc(hydroxJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "hydroxylated" should be (true)
  }
  hydroxVBN should "contain a hydrox PTM" in {
    val doc = testReach.mkDoc(hydroxVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "hydroxylated" should be (true)
  }
  hydroxJJWithSite should "contain a hydrox PTM with a site" in {
    val doc = testReach.mkDoc(hydroxJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "hydroxylated" should be (true)
  }
  hydroxJJIntercedingWithSite should "contain a hydrox PTM with a site" in {
    val doc = testReach.mkDoc(hydroxJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "hydroxylated" should be (true)
  }
  hydroxVBNWithSite should "contain a hydrox PTM with a site" in {
    val doc = testReach.mkDoc(hydroxVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "hydroxylated" should be (true)
  }
  hydroxVBNIntercedingWithSite should "contain a hydrox PTM with a site" in {
    val doc = testReach.mkDoc(hydroxVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "hydroxylated" should be (true)
  }

  aceJJ should "contain a ace PTM" in {
    val doc = testReach.mkDoc(aceJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "acetylated" should be (true)
  }
  aceVBN should "contain a ace PTM" in {
    val doc = testReach.mkDoc(aceVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "acetylated" should be (true)
  }
  aceJJWithSite should "contain a ace PTM with a site" in {
    val doc = testReach.mkDoc(aceJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "acetylated" should be (true)
  }
  aceJJIntercedingWithSite should "contain a ace PTM with a site" in {
    val doc = testReach.mkDoc(aceJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "acetylated" should be (true)
  }
  aceVBNWithSite should "contain a ace PTM with a site" in {
    val doc = testReach.mkDoc(aceVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "acetylated" should be (true)
  }
  aceVBNIntercedingWithSite should "contain a ace PTM with a site" in {
    val doc = testReach.mkDoc(aceVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "acetylated" should be (true)
  }

  glycoJJ should "contain a glyco PTM" in {
    val doc = testReach.mkDoc(glycoJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "glycosylated" should be (true)
  }
  glycoVBN should "contain a glyco PTM" in {
    val doc = testReach.mkDoc(glycoVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "glycosylated" should be (true)
  }
  glycoJJWithSite should "contain a glyco PTM with a site" in {
    val doc = testReach.mkDoc(glycoJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "glycosylated" should be (true)
  }
  glycoJJIntercedingWithSite should "contain a glyco PTM with a site" in {
    val doc = testReach.mkDoc(glycoJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "glycosylated" should be (true)
  }
  glycoVBNWithSite should "contain a glyco PTM with a site" in {
    val doc = testReach.mkDoc(glycoVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "glycosylated" should be (true)
  }
  glycoVBNIntercedingWithSite should "contain a glyco PTM with a site" in {
    val doc = testReach.mkDoc(glycoVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "glycosylated" should be (true)
  }

  methJJ should "contain a meth PTM" in {
    val doc = testReach.mkDoc(methJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "methylated" should be (true)
  }
  methVBN should "contain a meth PTM" in {
    val doc = testReach.mkDoc(methVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "methylated" should be (true)
  }
  methJJWithSite should "contain a meth PTM with a site" in {
    val doc = testReach.mkDoc(methJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "methylated" should be (true)
  }
  methJJIntercedingWithSite should "contain a meth PTM with a site" in {
    val doc = testReach.mkDoc(methJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "methylated" should be (true)
  }
  methVBNWithSite should "contain a meth PTM with a site" in {
    val doc = testReach.mkDoc(methVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "methylated" should be (true)
  }
  methVBNIntercedingWithSite should "contain a meth PTM with a site" in {
    val doc = testReach.mkDoc(methVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "methylated" should be (true)
  }

  sumoJJ should "contain a sumo PTM" in {
    val doc = testReach.mkDoc(sumoJJ, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "sumoylated" should be (true)
  }
  sumoVBN should "contain a sumo PTM" in {
    val doc = testReach.mkDoc(sumoVBN, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "sumoylated" should be (true)
  }
  sumoJJWithSite should "contain a sumo PTM with a site" in {
    val doc = testReach.mkDoc(sumoJJWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "sumoylated" should be (true)
  }
  sumoJJIntercedingWithSite should "contain a sumo PTM with a site" in {
    val doc = testReach.mkDoc(sumoJJIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "sumoylated" should be (true)
  }
  sumoVBNWithSite should "contain a sumo PTM with a site" in {
    val doc = testReach.mkDoc(sumoVBNWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "sumoylated" should be (true)
  }
  sumoVBNIntercedingWithSite should "contain a sumo PTM with a site" in {
    val doc = testReach.mkDoc(sumoVBNIntercedingWithSite, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "sumoylated" should be (true)
  }

  val sent1 = "The phosphorylated AKT binds to ASPP2."
  val sent1b = "The ubiquitinated AKT binds to ASPP2."
  "ReachSystem" should "not find a PTMs as events" in {
    // TODO: Both fail! (DANE + MARCO)
    var mentions = parseSentence(sent1)
    val p = mentions.find(_ matches "Phosphorylation") // Dane: this is a PTM not an event!
    p.isDefined should be (false) // Dane
    var b = mentions.find(_ matches "Binding") // Marco: why does this fail??
    b.isDefined should be (true) // Marco

    mentions = parseSentence(sent1b)
    val u = mentions.find(_ matches "Ubiquitination")
    u.isDefined should be (false)
    b = mentions.find(_ matches "Binding")
    b.isDefined should be (true)
  }

  val sent2 = "We demonstrate that the RBD of PI3KC2β binds nucleotide-free Ras in vitro."
  s"""PI3KC2β in "$sent2"""" should "have 1 \"site of protein\" EventSite modification" in {
    // Also: if the entity modification has no type, it should be propagated up in the event using the entity
    val mentions = getEntities(sent2)
    val p = mentions.filter(_ matches "Gene_or_gene_product")
    p should have size (1)
    // This tests whether the modification is present
    getEventSites(p.head) should have size (1)
  }

  // Test EventSite modifications
  val sent3a = "Experiments revealed ubiquitination at Lys residues 104 and 147 of K-Ras"
  s"""K-Ras in "$sent3a"""" should "have 2 EventSites after the modificationEngine" in {
    val mentions =  getEntities(sent3a)
    val p = mentions.filter(_ matches "Family")
    p should have size (1)
    // This tests whether the modification is present
    getEventSites(p.head) should have size (2)
  }

  // Test EventSite modifications
  val sent3b = "Experiments revealed ubiquitination at Lys residues 117, 147, and 170 for H-Ras."
  s""""H-Ras in "$sent3b"s""" should "have 3 EventSites after the modificationEngine" in {
    val mentions =  getEntities(sent3b)
    val p = mentions.filter(_ matches "Family")
    p should have size (1)
    // This tests whether the modification is present
    getEventSites(p.head) should have size (3)
  }

  val sent4 = "Phosphorylated Mek binds to GTP."
  sent4 should "not contain a phosphorylation event (this is a PTM)" in {
    val doc = testReach.mkDoc(sent4, "testdoc")
    val mentions = testReach extractFrom doc
    mentions.exists(_ matches "Phosphorylation") should be (false)
  }

  val sent5 = "Ligation of ASPP2 to hydroxylated RAS-GTP promotes apoptosis."
  sent5 should "not contain a hydroxylation event (this is a PTM)" in {
    val doc = testReach.mkDoc(sent5, "testdoc")
    val mentions = testReach extractFrom doc
    mentions.exists(_ matches "Hydroxylation") should be (false)
  }

  val sent6 = "Optineurin regulates NF-kappaB activation by mediating interaction of CYLD with ubiquitinated RIP."
  sent6 should "not contain a ubiquitination event (this is a PTM)" in {
    val doc = testReach.mkDoc(sent6, "testdoc")
    val mentions = testReach extractFrom doc
    mentions.exists(_ matches "Ubiquitination") should be (false)
  }

  val sent7 = "The ubiquitinated Ras protein phosphorylates AKT."
  // the example text says that Ras is ubiquitinated
  // that should be reflected as a PTM in ras.modifications
  sent7 should "contain a Ras with a PTM" in {
    val doc = testReach.mkDoc(sent7, docId, chunkId)
    val mentions = testReach.extractEntitiesFrom(doc)
    val ras = mentions.find(_.text contains "Ras")
    ras.isDefined should be (true)
    // there is only one PTM in the example text
    ras.get.modifications.size == 1 should be (true)
    val ptm = ras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }

  val sent8 = "Ras does not phosphorylate Mek"
  sent8 should "have a negated positive regulation" in {
    val doc = testReach.mkDoc(sent8, docId, chunkId)
    val mentions = testReach extractFrom doc
    mentions filter (_ matches "Event") should have size (2)
    val phospho = mentions.find(_ matches "Phosphorylation")
    phospho should be ('defined)
    phospho.get.arguments.keySet should not contain ("cause")
    phospho.get.modifications.filter(_.isInstanceOf[Negation]) should be ('empty)
    val reg = mentions.find(_ matches "Positive_regulation")
    reg should be ('defined)
    reg.get.modifications.filter(_.isInstanceOf[Negation]) should have size (1)
  }

  val sent9 = "The phosphorylated p53 by ASPP2 is doing something..."
  // this is not a PTM! It is an event with a cause
  sent9 should "contain 1 phosphorylation and 1 regulation event" in {
    val mentions = parseSentence(sent9)
    hasEventWithArguments("Phosphorylation", List("p53"), mentions) should be (true)
    hasPositiveRegulationByEntity("ASPP2", "Phosphorylation", List("p53"), mentions) should be (true)
  }

  //
  // a few tests for mutation modifications
  //
  val sent10 = "Note that only K650M and K650E-FGFR3 mutants cause STAT1 phosphorylation"
  sent10 should "have 2 mutations for FGFR3" in {
    val mentions = parseSentence(sent10)
    val fgfr = mentions.filter(m => (m.text contains "FGFR3") && m.isInstanceOf[BioTextBoundMention])
    fgfr should have size (1)
    fgfr.head.countMutations should be (2)
  }

  val sent11 = "Note that only FGFR3 K650M causes STAT1 phosphorylation"
  sent11 should "have 1 mutation for FGFR3" in {
    val mentions = parseSentence(sent11)
    val fgfr = mentions.filter(m => (m.text contains "FGFR3") && m.isInstanceOf[BioTextBoundMention])
    fgfr should have size (1)
    fgfr.head.countMutations should be (1)
  }

  val sent12 = "Note that only the K650M-FGFR3 mutant causes STAT1 phosphorylation"
  sent12 should "have 1 mutation for FGFR3" in {
    val mentions = parseSentence(sent12)
    val fgfr = mentions.filter(m => (m.text contains "FGFR3") && m.isInstanceOf[BioTextBoundMention])
    fgfr should have size (1)
    fgfr.head.hasMutation("K650M") should be (true)
  }

  val sent13 = "monoubiquitinated K-Ras is less sensitive than the unmodified protein to GAP-mediated GTP hydrolysis"
  sent13 should "not contain a ubiquitination event (this is a PTM)" in {
    val mentions = parseSentence(sent13)
    mentions.count(_ matches "Ubiquitination") should be (0)
    hasEventWithArguments("Ubiquitination", List("K-Ras"), mentions) should be (false)
    val kras = mentions.find(_.text contains "K-Ras")
    kras.isDefined should be (true)
    // there is only one PTM in the example text
    kras.get.modifications.size == 1 should be (true)
    val ptm = kras.get.modifications.head
    ptm.label == "ubiquitinated" should be (true)
  }

  //
  // a few tests for modifications in parens
  //
  val sent14 = "all six FGFR3 mutants induced activatory ERK(T202/Y204) phosphorylation (Fig. 2)."
  sent14 should "contain 2 phosphorylations (one for each ERK mutation) and 2 Positive Regulations" in {
    val mentions = parseSentence(sent14)

    // We have one phosphorylation per Site
    val phosphos = mentions.filter(_ matches "Phosphorylation")
    phosphos should have size (2)
    val s1 = phosphos.head.arguments.getOrElse("site", Nil)
    val s2 = phosphos.last.arguments.getOrElse("site", Nil)
    s1 should have size (1)
    s2 should have size (1)
    val ss = Seq(s1.head.text, s2.head.text)
    ss should contain ("T202")
    ss should contain ("Y204")

    // There should be 2 Positive Regulations (one for each phospho)
    mentions.count(_ matches "Positive_regulation") should be (2)
  }

  val sent15 = "all six FGFR3 mutants induced activatory ERK(K156M/H204M) phosphorylation (Fig. 2)."
  sent15 should "contain 2 Positive Regulations NOT Activations (1 for each ERK mutation)" in {
    val mentions = parseSentence(sent15)

    // We have 1 Reg per ERK mutant
    val regs = mentions.filter(_ matches "Positive_regulation")
    regs should have size (2)
  }

  val sent16 = "all six FGFR3 mutants induced activatory ERK(K156M, H204M) phosphorylation (Fig. 2)."
  sent16 should "contain 2 Positive Regulations NOT Activations (1 for each ERK mutation)" in {
    val mentions = parseSentence(sent16)

    // We have 1 Reg per ERK mutant
    val regs = mentions.filter(_ matches "Positive_regulation")
    regs should have size (2)

  }

  val siteTest1 = "activatory ERK(T202/Y204) phosphorylation (Fig. 2)."
  siteTest1 should "contain two sites for " in {
    val mentions = parseSentence(siteTest1)

    // We have one phosphorylation per Site
    val phosphos = mentions.filter(_ matches "Phosphorylation")
    phosphos should have size (2)
    val s1 = phosphos.head.arguments.getOrElse("site", Nil)
    val s2 = phosphos.last.arguments.getOrElse("site", Nil)
    s1 should have size (1)
    s2 should have size (1)
    val ss = Seq(s1.head.text, s2.head.text)
    ss should contain ("T202")
    ss should contain ("Y204")
  }

  val mutantTest1 = "all six FGFR3 mutants induced activatory ERK(K156M/H204M) phosphorylation (Fig. 2)."
  mutantTest1 should "contain 2 mutations for ERK and 1 for FGFR3" in {
    val mentions = parseSentence(mutantTest1)

    val fgfr = mentions filter(_.text == "FGFR3")
    fgfr should have size (1)
    fgfr.head.countMutations should be (1)
    fgfr.head hasMutation "mutants" should be (true)

    val erk = mentions filter(_.text == "ERK")
    erk should have size (1)
    erk.head.countMutations should be (2)
    erk.head hasMutation "K156M" should be (true)
    erk.head hasMutation "H204M" should be (true)
  }

  val mutantTest2 = "all six FGFR3 mutants induced activatory ERK(K156M, H204M) phosphorylation (Fig. 2)."
  mutantTest2 should "contain 2 mutations for ERK and 1 for FGFR3" in {
    val mentions = parseSentence(mutantTest2)

    val fgfr = mentions filter(_.text == "FGFR3")
    fgfr should have size (1)
    fgfr.head.countMutations should be (1)
    fgfr.head hasMutation "mutants" should be (true)

    val erk = mentions filter(_.text == "ERK")
    erk should have size (1)
    erk.head.countMutations should be (2)
    erk.head hasMutation "K156M" should be (true)
    erk.head hasMutation "H204M" should be (true)
  }

  val mutantTest3 = "MEK R567Q"
  mutantTest3 should "contain 1 entity with 1 Mutant modification" in {
    val mentions = parseSentence(mutantTest3)
    mentions should have size (1)
    mentions.head.countMutations should be (1)
    mentions.head hasMutation "R567Q" should be (true)
  }

  val mutantTest4 = "MEK mutant R567Q"
  mutantTest4 should "contain 1 entity with 1 Mutant modification" in {
    val mentions = parseSentence(mutantTest4)
    mentions should have size (1)
    mentions.head.countMutations should be (1)
    mentions.head hasMutation "mutant R567Q" should be (true)
  }

  val mutantTest5 = "MEK (R678Q, G890K)"
  mutantTest5 should "contain 1 entity with 2 Mutant modification" in {
    val mentions = parseSentence(mutantTest5)
    mentions should have size (1)
    mentions.head.countMutations should be (2)
    mentions.head hasMutation "R678Q" should be (true)
    mentions.head hasMutation "G890K" should be (true)
  }

  val mutantTest6 = "K111M and K112M ASPP1 mutants and ASPP2"
  mutantTest6 should "countain ASPP1 with 2 Mutant mods and ASPP2 with 0 Mutant mods" in {
    val mentions = parseSentence(mutantTest6)
    mentions should have size (2)
    val asppOne = mentions filter (_.text == "ASPP1")
    asppOne should have size (1)
    asppOne.head.countMutations should be (2)
    asppOne.head hasMutation "K111M" should be (true)
    asppOne.head hasMutation "K112M" should be (true)

    val asppTwo = mentions filter (_.text == "ASPP2")
    asppTwo should have size (1)
    asppTwo.head.countMutations should be (0)
  }

  val mutantTest7 = "K111M, K112M, and K113M ASPP1 mutants and ASPP2"
  mutantTest7 should "countain ASPP1 with 3 Mutant mods and ASPP2 with 0 Mutant mods" in {
    val mentions = parseSentence(mutantTest7)
    mentions should have size (2)
    val asppOne = mentions filter (_.text == "ASPP1")
    asppOne should have size (1)
    asppOne.head.countMutations should be (3)
    asppOne.head hasMutation "K111M" should be (true)
    asppOne.head hasMutation "K112M" should be (true)
    asppOne.head hasMutation "K113M" should be (true)

    val asppTwo = mentions filter (_.text == "ASPP2")
    asppTwo should have size (1)
    asppTwo.head.countMutations should be (0)
  }

  val mutantTest8 = "ASPP1 mutants K111M, K112M, and K113M and ASPP2"
  mutantTest8 should "countain ASPP1 with 3 Mutant mods and ASPP2 with 0 Mutant mods" in {
    val mentions = parseSentence(mutantTest8)
    mentions should have size (2)
    val asppOne = mentions filter (_.text == "ASPP1")
    asppOne should have size (1)
    asppOne.head.countMutations should be (3)
    asppOne.head hasMutation "K111M" should be (true)
    asppOne.head hasMutation "K112M" should be (true)
    asppOne.head hasMutation "K113M" should be (true)

    val asppTwo = mentions filter (_.text == "ASPP2")
    asppTwo should have size (1)
    asppTwo.head.countMutations should be (0)
  }
}



