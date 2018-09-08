package org.stairwaybook.xml

case class CCTherm (
  description: String,
  yearMade: Int,
  dateObtained: String,
  bookPrice: Int,
  purchasePrice: Int,
  condition: Int) {
  override def toString = description
  def toXML =
    <cctherm>
      <description>{description}</description>
      <yearMade>{yearMade}</yearMade>
      <dateObtained>{dateObtained}</dateObtained>
      <bookPrice>{bookPrice}</bookPrice>
      <purchasePrice>{purchasePrice}</purchasePrice>
      <condition>{condition}</condition>
    </cctherm>
}

object CCTherm {
  def fromXML(node: scala.xml.Node): CCTherm =
    CCTherm(
      (node \ "description").text,
      (node \ "yearMade").text.toInt,
      (node \ "dateObtained").text,
      (node \ "bookPrice").text.toInt,
      (node \ "purchasePrice").text.toInt,
      (node \ "condition").text.toInt
    )
}