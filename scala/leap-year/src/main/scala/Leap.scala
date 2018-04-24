/**
  * Given a year, determine if it's a leap year.
  *
  * a leap year in the Gregorian calendar occurs:
  *     on every year that is evenly divisible by 4
  *         except every year that is evenly divisible by 100
  *             unless the year is also evenly divisible by 400
  */
object Leap {

  def leapYear(year: Int): Boolean = {

    def divisibleBy100 : Boolean = year match {
      case _ if (year % 100 == 0) => true
      case _                      => false
    }
    def divisibleBy400 : Boolean = year match {
      case _ if year % 400 == 0 => true
      case _                    => false
    }

    // do match and return...
    year match {
      case _ if (divisibleBy100 && divisibleBy400) => true
      case _ if divisibleBy100                     => false
      case _ if (year % 4 == 0)                    => true
      case _                                       => false
     }
  }
}
