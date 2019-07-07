import org.scalatest._
import projecteuler.Common

class CommonSuite extends FlatSpec with Matchers {
  "getProperDivisors" should "work for 12" in {
    val expected = List(1, 2, 3, 4, 6)
    val actual = Common.getProperDivisors(12).toList.sorted
    actual should be (expected)
  }

  it should "work for 28" in {
    val expected = List(1, 2, 4, 7, 14)
    val actual = Common.getProperDivisors(28).toList.sorted
    actual should be (expected)
  }
}