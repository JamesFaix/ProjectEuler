import org.scalatest.FlatSpec
import projecteuler.Problem24

class Problem24Suite extends FlatSpec {
  "getAnswer" should "return the correct answer" in
    assertResult(0) {
      Problem24.getAnswer()
    }
}