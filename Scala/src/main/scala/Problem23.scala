package projecteuler

/*
  A perfect number is a number for which the sum of its proper divisors
  is exactly equal to the number. For example, the sum of the proper divisors of
  28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

  A number n is called deficient if the sum of its proper divisors is less
  than n and it is called abundant if this sum exceeds n.

  As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
  the smallest number that can be written as the sum of two abundant numbers is 24.

  By mathematical analysis, it can be shown that all integers greater than 28123
  can be written as the sum of two abundant numbers. However, this upper limit
  cannot be reduced any further by analysis even though it is known that the greatest
  number that cannot be expressed as the sum of two abundant numbers is less than this limit.

  Find the sum of all the positive integers which cannot be written as the
  sum of two abundant numbers.
 */

object Problem23 {

  def getAnswer() : Int = {
    val upperBound = 28123
    val abundantNumbers = getAbundantNumbersLessThanOrEqualTo(upperBound).toSet

    (1 to upperBound)
      .filter(n => !canBeWrittenAsSumOfTwoAbundantNumbers(n, abundantNumbers))
      .sum
  }

  def isPerfect(n : Int) : Boolean =
    Common.getProperDivisors(n).sum == n

  def isAbundant(n : Int) : Boolean =
    Common.getProperDivisors(n).sum > n

  def isDeficient(n : Int) : Boolean =
    Common.getProperDivisors(n).sum < n

  def getAbundantNumbersLessThanOrEqualTo(upperBound : Int) : Iterable[Int] =
    (1 to upperBound).filter(isAbundant)

  def getUpperBoundForAddends(n : Int) : Int =
    Math.ceil(n/2.0).toInt

  def canBeWrittenAsSumOfTwoAbundantNumbers(n : Int, abundantNumbersCache : Set[Int]) : Boolean = {
    val upperBound = getUpperBoundForAddends(n)
    abundantNumbersCache
        .exists(x => x <= upperBound
          && abundantNumbersCache.contains(n - x))
  }
}

/*
  You are the 93494th person to have solved this problem.
 */
