package dsl

import model.{ButtonStyle, Style}

import scala.util.parsing.combinator.RegexParsers

class StyleParser extends RegexParsers {

  def styleParser: Parser[Style] =
    "Style:" ~
      "Buttonstyle:" ~ buttonStyle ~
      "Movieinformationstyle:" ~ movieInformationStyle ~
      "Moviedescriptionstyle:" ~ movieDescriptionStyle ^^ {
      case _ ~ buttonStyle ~ _ ~ movieInformationStyle ~ _ ~ movieDescriptionStyle =>
        Style(buttonStyle, movieInformationStyle, movieDescriptionStyle)
    }

  def buttonStyle: Parser[ButtonStyle] =
    "Font-style:" ~ fontStyle ~
      "Font-name:" ~ fontName ~
      "Font-size:" ~ integer ~
      "Border-color:" ~ color ~
      "Border-width:" ~ integer ^^ {
      case _ ~ bfst ~ _ ~ bfna ~ _ ~ bfsi ~ _ ~ bbco ~ _ ~ bbwi =>
        ButtonStyle(bfst, bfna, bfsi, bbco, bbwi)
    }

  def movieInformationStyle: Parser[MovieInformationStyle] =
    "Font-style:" ~ fontStyle ~
      "Font-name:" ~ fontName ~
      "Font-size:" ~ integer ^^ {
      case _ ~ mifst ~ _ ~ mifna ~ _ ~ mifsi =>
        MovieInformationStyle(mifst, mifna, mifsi)
    }

  def movieDescriptionStyle: Parser[MovieDescriptionStyle] =
    "Font-style:" ~ fontStyle ~
      "Font-name:" ~ fontName ~
      "Font-size:" ~ integer ^^ {
      case _ ~ mdfst ~ _ ~ mdfna ~ _ ~ mdfsi =>
        MovieDescriptionStyle(mdfst, mdfna, mdfsi)
    }

  private def color: Parser[String] =
    """Red""" | """Black""" | """Green""" | """Yellow""" | """Blue"""

  private def fontName: Parser[String] =
    """Arial""" | """Courier""" | """TimesRoman"""

  private def fontStyle: Parser[String] =
    """Italic""" | """Bold""" | """Plain"""


  private def rating: Parser[Int] =
    ("""1""" | """2""" | """3""" | """4""" | """5""") ^^ (_.toInt)

  private def fsk: Parser[Int] =
    ("""0""" | """6""" | """12""" | """16""" | """18""") ^^ (_.toInt)

  private def time: Parser[String] =
    """\d{2}:\d{2}""".r

  private def date: Parser[String] =
    """\d{2}.\d{2}.\d{4}""".r

  private def weekday: Parser[String] =
    """Montag""" | """Dienstag""" |
      """Mittwoch""" |
      """Donnerstag""" |
      """Freitag""" |
      """Samstag""" |
      """Sonntag""" ^^ (_.toString)

  private def text: Parser[String] =
    """[^\v]+""".r ^^ (_.toString)


  private def integer: Parser[Int] =
    """\d+""".r ^^ (_.toInt)
}
