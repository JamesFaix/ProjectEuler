import org.scalatest.FlatSpec
import projecteuler.Problem22

class Problem22Suite extends FlatSpec {
  "getAnswer" should "return the correct answer" in
    assertResult(871198282) {
      Problem22.getAnswer()
    }

  "getIndexOfColin" should "return 937" in
    assertResult(937) {
      Problem22.getIndexOfColin()
    }

  "getTotalCharacterValue" should "return 53 for COLIN" in
    assertResult(53) {
      Problem22.getTotalCharacterValue("COLIN")
    }

  "getCharacterValue" should "return 1 for 'A'" in
    assertResult(1) {
      Problem22.getCharacterValue('A')
    }

  it should "return 1 for 'a'" in
    assertResult(1) {
      Problem22.getCharacterValue('a')
    }

  it should "return 26 for 'Z'" in
    assertResult(26) {
      Problem22.getCharacterValue('Z')
    }

  it should "return 1 for 'z'" in
    assertResult(26) {
      Problem22.getCharacterValue('z')
    }
}