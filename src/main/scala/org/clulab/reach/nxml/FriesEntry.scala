package org.clulab.reach.nxml

import ai.lum.nxmlreader.NxmlDocument


case class FriesEntry(
  name: String,
  chunkId: String,
  sectionId: String,
  sectionName: String,
  isTitle: Boolean,
  text: String
) {

  override def toString(): String =  s"$chunkId\t$sectionName\t$sectionId\t${if(isTitle) 1 else 0}\t$text"

  def this(nxmldoc: NxmlDocument) = this(
    name = nxmldoc.pmc,
    // we are using the PMC as the chunk-id because we now read
    // the whole paper in a single chunk
    chunkId = nxmldoc.pmc,
    sectionId = nxmldoc.standoff.path,
    sectionName = "",
    false,
    nxmldoc.standoff.text
  )

  def this(paperId: String, nxmldoc: NxmlDocument) = this(
    name = paperId,
    // we are using the PMC as the chunk-id because we now read
    // the whole paper in a single chunk
    chunkId = nxmldoc.pmc,
    sectionId = nxmldoc.standoff.path,
    sectionName = "",
    isTitle = false,
    text = nxmldoc.standoff.text
  )
}
