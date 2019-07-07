package projecteuler

object Common {

  def getProperDivisors(n : Int) : Iterable[Int] = {
    val maxProperDivisor = math.floor(n/2).toInt
    (1 to maxProperDivisor)
      .filter(n % _ == 0)
  }
}
