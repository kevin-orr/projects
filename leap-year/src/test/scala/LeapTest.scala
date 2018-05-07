import org.scalatest.{Matchers, FunSuite}

/** @version 1.0.0 */
class LeapTest extends FunSuite with Matchers {

  test("2360 is a leap year") {
    Leap.leapYear(2360) should be (true)
  }

  test("but 2361 is not a leap year") {
    Leap.leapYear(2361) should be (false)
  }

  test("2015 is not a leap year") {
    Leap.leapYear(2015) should be (false)
  }

  test("1816 is a leap year") {
    Leap.leapYear(1816) should be (true)
  }

  test("1817 is not a leap year") {
    Leap.leapYear(1817) should be (false)
  }

  test("2016 is a leap year") {
    Leap.leapYear(2016) should be (true)
  }

  test("2100 is not a leap year") {
    Leap.leapYear(2100) should be (false)
  }

  test("2000 is a leap year") {
    Leap.leapYear(2000) should be (true)
  }


}