import org.scalatest.FlatSpec
import projecteuler.Problem21

class Problem21Suite extends FlatSpec {
  "getAnswer" should "return the correct answer" in
    assertResult(31626) {
      Problem21.getAnswer()
    }

  "getSumOfProperDivisors" should "return the correct value for 24" in
    //Proper divisors are 1, 2, 3, 4, 6, 8, 12
    //Sum is 36
    assertResult(36) {
      Problem21.getSumOfProperDivisors(24)
    }

  it should "return the correct value for 99" in
    //Proper divisors are 1, 3, 9, 11, 33
    //Sum is 57
    assertResult(57) {
      Problem21.getSumOfProperDivisors(99)
    }

  "getAmicableCompliment" should "return None for numbers that would be their own compliment" in
    //Proper divisors of 6 are [1,2,3] which sums to 6
    assertResult(None) {
      Problem21.getAmicableCompliment(6)
    }

  it should "return the correct value for 220" in
    //This example is given in the problem instructions
    assertResult(Some(284)) {
      Problem21.getAmicableCompliment(220)
    }

  it should "return the correct value for 284" in
    //This example is given in the problem instructions
    assertResult(Some(220)) {
      Problem21.getAmicableCompliment(284)
    }
}
