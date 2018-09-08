package org.stairwaybook.rational

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = (if (d < 0) -n else n) / g
  val denom: Int = d.abs / g
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def this(n: Int) = this(n, 1)
  def + (that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def + (i: Int): Rational = new Rational(numer + i * denom, denom)
  def - (that: Rational): Rational = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  def - (i: Int): Rational = new Rational(numer - i * denom, denom)
  def * (that: Rational): Rational = new Rational(numer * that.numer, denom * that.denom)
  def * (i: Int): Rational = new Rational(numer * i, denom)
  def / (that: Rational): Rational = new Rational(numer * that.denom, denom * that.numer)
  def / (i: Int): Rational = new Rational(numer, denom * i)
  def compare(that: Rational) = (this.numer * that.denom) - (that.numer * this.denom)
  override def equals(other: Any) =
    other match {
      case that: Rational =>
        (that canEqual this) &&
        this.numer == that.numer &&
        this.denom == that.denom
      case _ => false
    }
  def canEqual(other: Any) = other.isInstanceOf[Rational]
  override def hashCode = (numer, denom).##
  override def toString = if (denom == 1) numer.toString else numer + "/" + denom
}