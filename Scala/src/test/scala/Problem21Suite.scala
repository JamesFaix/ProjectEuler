import org.scalatest.FlatSpec
import projecteuler.Problem21

class Problem21Suite extends FlatSpec {
  "Problem 21" should "return the correct answer" in {
    assertResult(0) {
      Problem21.getAnswer()
    }
  }
}
