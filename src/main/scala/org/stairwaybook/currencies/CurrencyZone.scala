package org.stairwaybook.currencies

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    def + (that: Currency): Currency = make(this.amount + that.amount)
    def * (x: Double): Currency = make((this.amount * x).toLong)
    def - (that: Currency): Currency = make(this.amount - that.amount)
    def / (x: Double): Currency = make((this.amount / x).toLong)
    def / (that: Currency): Currency = make(this.amount / that.amount)
    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(
        other.amount.toDouble * Converter.exchangeRate(other.designation)(this.designation)
      ))
    private def decimals(n: Long): Int =
      if (n == 1) 0 else 1 + decimals(n / 10)
    override def toString =
      ((amount.toDouble / CurrencyUnit.amount.toDouble) formatted ("%." + decimals(CurrencyUnit.amount) + "f") + " " + designation)
  }
  val CurrencyUnit: Currency
}

object USA extends CurrencyZone {
  abstract class Dollar extends AbstractCurrency {
    def designation = "USD"
  }
  type Currency = Dollar
  def make(cents: Long) = new Currency {
    val amount = cents
  }
  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar
}

object Europe extends CurrencyZone {
  abstract class Euro extends AbstractCurrency {
    def designation = "EUR"
  }
  type Currency = Euro
  def make(cents: Long) = new Currency {
    val amount = cents
  }
  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro
}

object Switzerland extends CurrencyZone {
  abstract class Chf extends AbstractCurrency {
    def designation = "CHF"
  }
  type Currency = Chf
  def make(ct: Long) = new Currency {
    val amount = ct
  }
  val Ct = make(1)
  val Chf = make(100)
  val CurrencyUnit = Chf
}

object Japan extends CurrencyZone {
  abstract class Yen extends AbstractCurrency {
    def designation = "JPY"
  }
  type Currency = Yen
  def make(yen: Long) = new Currency {
    val amount = yen
  }
  val Yen = make(1)
  val CurrencyUnit = Yen
}