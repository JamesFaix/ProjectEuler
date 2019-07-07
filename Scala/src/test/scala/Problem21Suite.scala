import org.scalatest.FlatSpec
import projecteuler.Problem21

class Problem21Suite extends FlatSpec {
  "getAnswer" should "return the correct answer" in {
    assertResult(31626) {
      Problem21.getAnswer()
    }
  }

  "getSumOfProperDivisors" should "return the correct value for 24" in {
    val input = 24
    //Proper divisors are 1, 2, 3, 4, 6, 8, 12
    //Sum is 36
    assertResult(36) {
      Problem21.getSumOfProperDivisors(input)
    }
  }

  "getSumOfProperDivisors" should "return the correct value for 99" in {
    val input = 99
    //Proper divisors are 1, 3, 9, 11, 33
    //Sum is 57
    assertResult(57) {
      Problem21.getSumOfProperDivisors(input)
    }
  }

  "getAmicableCompliment" should "return None for numbers that would be their own compliment" in {
    //Proper divisors of 6 are [1,2,3] which sums to 6
    assertResult(None) {
      Problem21.getAmicableCompliment(6)
    }
  }

  "getAmicableCompliment" should "return the correct value for 220" in {
    //This example is given in the problem instructions
    assertResult(Some(284)) {
      Problem21.getAmicableCompliment(220)
    }
  }

  "getAmicableCompliment" should "return the correct value for 284" in {
    //This example is given in the problem instructions
    assertResult(Some(220)) {
      Problem21.getAmicableCompliment(284)
    }
  }
}
