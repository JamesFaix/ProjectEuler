import org.scalatest.FlatSpec
import projecteuler.Problem24

class Problem24Suite extends FlatSpec {
  "getAnswer" should "return the correct answer" in
    assertResult("2783915460") {
      Problem24.getAnswer()
    }

  "getNthPermutationOfCharacters" should "return 10th permutation of ABCD" in
    assertResult("BCDA") {
      Problem24.getNthPermutationOfCharacters(10, "ABCD".toSet)
    }
}