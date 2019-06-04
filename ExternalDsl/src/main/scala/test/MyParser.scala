package test

import scala.util.parsing.combinator.RegexParsers

class MyParser extends RegexParsers {

  def gameParser: Parser[Topic] =
    "Tipp-Abgabe:" ~ text ~
      "Frage:" ~ text ~
      "Wähle" ~ count ~ "aus" ~ choices ^^ {
      case _ ~ t ~ _ ~ n ~ _ ~ c ~ _ ~ ch =>
        Topic(t, n, c, ch)
    }

  private def text: Parser[String] =
    """[^\v]+""".r ^^ (_.toString)


  private def integer: Parser[Int] =
    """\d+""".r ^^ (_.toInt)

  // optional integer with default value
  private def count: Parser[Int] =
    opt(integer) ^^ (_.getOrElse(1))

  private def choices: Parser[List[Choice]] =
    rep(multiNumberChoice | simpleChoice) ^^
      (c => c.flatten)

  private def choiceName: Parser[String] =
    """[^\v>]+""".r ^^ (_.trim)

  private def double: Parser[Double] =
    """\d+(\.\d+)?""".r ^^ (_.toDouble)

  private def simpleChoice: Parser[List[Choice]] =
    choiceName ~ ">" ~ double ^^ {
      case t ~ _ ~ d => List(Choice(t, d))
    }

  private def multiNumberChoice: Parser[List[Choice]] =
    integer ~ ".." ~ integer ~ ">" ~ double ^^ {
      case from ~ _ ~ to ~ _ ~ f =>
        from.to(to).map(n => Choice(n.toString, f)).toList
    }

}
