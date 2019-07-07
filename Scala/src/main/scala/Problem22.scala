package projecteuler

import scala.io.Source

/*
  Using names.txt (right click and 'Save Link/Target As...'),
  a 46K text file containing over five-thousand first names,
  begin by sorting it into alphabetical order.
  Then working out the alphabetical value for each name,
  multiply this value by its alphabetical position in the list to obtain a name score.

  For example, when the list is sorted into alphabetical order, COLIN,
  which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
  So, COLIN would obtain a score of 938 × 53 = 49714.

  What is the total of all the name scores in the file?
 */

object Problem22 {

  def getAnswer() : Int = {
     val names = getSortedNamesList()
  /*
    Based on the example of "COLIN" being 938 in alphabetical order,
    it appears that the instructions are using 1-based indexing, not 0-based.
    So multiply by (i+1) instead of (i) here
   */
    val scores : List[Int] = names.zipWithIndex.map(Function.tupled(
      (name, i) => getTotalCharacterValue(name) * (i+1)))
    scores.sum
    }

  def getIndexOfColin(): Int =
    getSortedNamesList().indexOf("COLIN")

  def getSortedNamesList() : List[String] = {
    val text = getTextFromResourceFile("names.txt")
    getNamesFromText(text).toList.sorted
  }

  def loanFile[T](getSource: () => Source, operation: Source => T): T = {
    var source: Source = null

    try {
      source = getSource()
      operation(source)
    }
    finally {
      if (source != null) source.close
    }
  }

  def getTextFromResourceFile(fileName: String): String =
    loanFile(
      () => Source.fromResource(fileName),
      _.getLines.mkString)

  def getNamesFromText(text: String): Iterable[String] =
    text
      .replace("\"", "")
      .split(",")

  def getCharacterValue(c: Char): Int = {
    val x = c.toInt
    if (x > 64 && x < 91) x - 64
    else if (x > 96 && x < 123) x - 96
    else 0
  }

  def getTotalCharacterValue(s: String): Int =
    s.map(getCharacterValue(_)).sum
}

/*
  You are the 121428th person to have solved this problem.
 */