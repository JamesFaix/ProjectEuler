package projecteuler

import scala.collection.mutable

/*
  Let d(n) be defined as the sum of proper divisors of n
  (numbers less than n which divide evenly into n).

  If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable
  pair and each of a and b are called amicable numbers.

  For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
  therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

  Evaluate the sum of all the amicable numbers under 10000.
*/

object Problem21 {
  def getAnswer() : Int =
    getAmicableNumbersLessThan(10000).sum

  def getSumOfProperDivisors(n : Int) : Int =
    {
      val maxProperDivisor = math.floor(n/2).toInt
      (1 to maxProperDivisor)
          .filter(n % _ == 0)
          .sum
    }

  def getAmicableCompliment(n : Int) : Option[Int] =
    {
      val d1 = getSumOfProperDivisors(n)
      if (d1 == n) None
      else {
        val d2 = getSumOfProperDivisors(d1)
        if (d2 == n) Some(d1) else None
      }
    }

  def getAmicableNumbersLessThan(n : Int) : Iterable[Int] =
    {
      val set = mutable.HashSet[Int]()

      for (i <- 1 to n
           if !set.contains(i)) {

        getAmicableCompliment(i) match {
          case Some(c) =>
            set.add(i)
            set.add(c)
          case None => ()
        }
      }

      println(set)

      set
    }
}

/*
  You are the 131941st person to have solved this problem.
 */