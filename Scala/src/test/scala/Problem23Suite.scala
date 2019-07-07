import org.scalatest.FlatSpec
import projecteuler.Problem23

class Problem23Suite extends FlatSpec {

  "getAnswer" should "return the correct answer" in
    assertResult(4179871) {
      Problem23.getAnswer()
    }

  //The following tests are based on 9 being deficient, 12 abundant, and 28 perfect

  "isPerfect" should "return false for 9" in
    assertResult(false) { Problem23.isPerfect(9) }

  it should "return false for 12" in
    assertResult(false) { Problem23.isPerfect(12) }

  it should "return true for 28" in
    assertResult(true) { Problem23.isPerfect(28) }

  "isAbundant" should "return false for 9" in
    assertResult(false) { Problem23.isAbundant(9) }

  it should "return true for 12" in
    assertResult(true) { Problem23.isAbundant(12) }

  it should "return false for 28" in
    assertResult(false) { Problem23.isAbundant(28) }

  "isDeficient" should "return true for 9" in
    assertResult(true) { Problem23.isDeficient(9) }

  it should "return false for 12" in
    assertResult(false) { Problem23.isDeficient(12) }

  it should "return false for 28" in
    assertResult(false) { Problem23.isDeficient(28) }

  //---

  "getUpperBoundForAddends" should "work for odd number" in
    assertResult(26) { Problem23.getUpperBoundForAddends(51) }

  it should "work for even number" in
    assertResult(50) { Problem23.getUpperBoundForAddends(100) }

  "getAbundantNumbersLessThanOrEqualTo" should "work for 12" in
    assertResult(List(12)) { Problem23.getAbundantNumbersLessThanOrEqualTo(12) }

  it should "work for 70" in
    //I just looked the first few abundant numbers up
    assertResult(List(12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60, 66, 70)) { Problem23.getAbundantNumbersLessThanOrEqualTo(70) }

  "canBeWrittenAsSumOfTwoAbundantNumbers" should "return true for 24" in
    assertResult(true) {
      val abundantNumbers = Problem23.getAbundantNumbersLessThanOrEqualTo(24).toSet
      Problem23.canBeWrittenAsSumOfTwoAbundantNumbers(24, abundantNumbers)
    }

  it should "return false for 23" in
    assertResult(false) {
      val abundantNumbers = Problem23.getAbundantNumbersLessThanOrEqualTo(23).toSet
      Problem23.canBeWrittenAsSumOfTwoAbundantNumbers(23, abundantNumbers)
    }

  it should "return true for 88" in
    assertResult(true) {
      val abundantNumbers = Problem23.getAbundantNumbersLessThanOrEqualTo(88).toSet
      Problem23.canBeWrittenAsSumOfTwoAbundantNumbers(88, abundantNumbers)
    }

}