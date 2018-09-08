package org.stairwaybook.extractor

object EMail {
  def apply(user: String, domain: String) = user + "@" + domain
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

object Domain {
  def apply(parts: String*): String = parts.reverse.mkString(".")
  def unapplySeq(whole: String): Option[Seq[String]] = Some(whole.split("\\.").reverse)
}

object ExpandedEMail {
  def unapplySeq(email: String): Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2) Some(parts(0), parts(1).split("\\.").reverse)
    else None
  }
}
