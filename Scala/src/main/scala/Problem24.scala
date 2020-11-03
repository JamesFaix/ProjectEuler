package projecteuler

import scala.collection.mutable

/*
  A permutation is an ordered arrangement of objects.
  For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.

  If all of the permutations are listed numerically or alphabetically,
  we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

    012
    021
    102
    120
    201
    210

  What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

/*
  Initial reasoning that does not require code:

  For a sequence of N digits there are N! permutations.
  For 0-9, that is 10! permutations.
  10! = 3,628,800

  10% of these permutations will start with each digit
  The first 362,880 start with 0
  362,881 to 725,760 start with 1
  725,761 to 1,088,640 start with 2
  Thus the 1,000,000th permutation starts with 2

  Of the 362,880 that start with 2, 1/9 of them begin with each non-2 digit
  362,880/9 = 8! =  40,320
  725,761 to 766,080 start with "20"
  766,081 to 806,400 start with "21"
  806,401 to 846,720 start with "23"
  846,721 to 887,040 start with "24"
  887,041 to 927,360 start with "25"
  927,361 to 967,680 start with "26"
  967,681 to 1,008,000 start with "27"

  Of the 40,320 that start with "27", 1/8 begin with each non-27 digit
  40,320/8 = 7! = 5040
  1,002,961 to 1,008,000 begin with "279"
  977,921 to 1,002,960 begin with "278"

  Of the 5040 that start with "278", 1/7 begin with each remaining digit
  5040/7 = 6! = 720
  1,002,241 to 1,002,960 begin with "2789"
  1,001,521 to 1,002,240 begin with "2786"
  1,000,801 to 1,001,520 begin with "2785"
  1,000,081 to 1,000,800 begin with "2784"
  999,361 to 1,000,080 begin with "2783"

  Of the 720 that start with "2783" 1/6 begin with each remaining digit
  720/6 = 5! = 120
  999,961 to 1,000,080 begin with "27839"

  Of the 120 that start with "27839" 1/5 begin with each remaining digit
  120/5 = 4! = 24
  999,961 to 999,984 begin with "278390"
  999,985 to 1,000,008 begin with "278391"

  Of the 24 that start with "278391", 1/4 begin with each remaining digit
  24/4 = 3! = 6
  1,000,003 to 1,000,008 begin with "2783916"
  999,997 to 1,000,002 begin with "2783915"

  Of the 6 that start with "2783915", 1/3 begin with each remaining digit
  6/3 = 2
  999,997 to 999,998 begin with "27839150"
  999,999 to 1,000,000 begin with "27839154"

  Of the 2 that start with "27839154" 1/2 begin with each remaining digit
  999,999 is "2783915406"
  1,000,000 is "2783915460"

  You are the 103607th person to have solved this problem.

  Now some code that can provide the answer more succinctly.
 */

 /*
  Simpler example: Find the 10th permutation of the set [A, B, C, D], lexicographically.

  Using letters helps view the set elements as symbols and not numeric values.
  Arithmetic cannot be done on these symbols (even if those symbols were digits).

  There are 4! = 24 permutations.

  1/4 (3! = 6) start with each symbol.
  1-6 start with A
  7-12 start with B

  Of those that start with B, 1/3 (2! = 2) start with each remaining symbol.
  7-8 start with BA
  9-10 start with BC

  Of those that start with BC, 1/2 (1! = 1) start with each remaining symbol.
  9 = BCAD
  10 - BCDA

  */

object Problem24 {
  def getAnswer() : String =
    getNthPermutationOfCharacters(1000000, "0123456789".toSet)

  def factorial(n : Int) : Int =
    if (n == 0) 1 else n * factorial(n-1)

  def getNthPermutationOfCharacters(n : Int, characters : Set[Char]) : String = {
    println(n)
    println(characters)

    val size = characters.size
    if (size == 1) characters.toList(0).toString()
    else {
      val bucketSize = factorial(size - 1)
      println("bucketSize " + bucketSize)

      val bucketNumber = Math.floor(n / bucketSize).toInt
      println("bucketNumber " + bucketNumber)

      val char = characters.toList.sorted.apply(bucketNumber)
      println("char " + char)

      val bucketMin = ((bucketNumber) * bucketSize) +1
      println("bucketMin " + bucketMin)

      Console.out.flush()

      char + getNthPermutationOfCharacters(Math.max(0, n - bucketMin), characters.filter(_ != char))
    }
  }
}
