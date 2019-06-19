package dsl

import model.{Program, ProgramPoint}
import scala.util.parsing.combinator.RegexParsers

class MovieParser extends RegexParsers {

  def movieParser: Parser[Program] =
    "Programm:" ~ programs ^^ {
      case _ ~ programs =>
        Program(programs)
    }

  private def programs: Parser[List[ProgramPoint]] =
    rep(program)

  private def program: Parser[ProgramPoint] =
    "Programmpunkt:" ~
      "Tag:" ~ weekday ~
      "Datum:" ~ date ~
      "Titel:" ~ text ~
      "ID:" ~ integer ~
      "Beschreibung:" ~ text ~
      "Bild:" ~ text ~
      "Uhrzeit:" ~ time ~
      "Dauer:" ~ integer ~
      "FSK:" ~ fsk ~
      "Bewertung:" ~ rating ~
      "Sender:" ~ text ^^ {
      case _ ~ day ~ _ ~ date ~ _ ~ title ~ _ ~ id ~ _ ~ desc ~ _ ~ img ~ _ ~ time ~ _ ~ len ~ _ ~ fsk ~ _ ~ rating ~ _ ~ channel =>
        ProgramPoint(day, date, title, id, desc, img, time, len, fsk, rating, channel)
    }

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