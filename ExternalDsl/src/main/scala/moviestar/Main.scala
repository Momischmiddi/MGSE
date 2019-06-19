package moviestar

import java.io.File
import java.util.Scanner

import gui.MainFrame

object Main extends MyParser {

  final var DSL_FILE_PATH = "src/main/scala/moviestar/DSLFile.Moviestar"

  def main(args: Array[String]): Unit = {
    val fileContent = readFileContent(new File(DSL_FILE_PATH))
    val program = parseAll(programParser, fileContent).get

    new MainFrame().createUI(program)
  }

  def readFileContent(dslFile: File): String = {

    val fileContents = new StringBuilder(dslFile.length.asInstanceOf[Int])

    try {
      val scanner = new Scanner(dslFile)
      try {
        while ( {
          scanner.hasNextLine
        }) fileContents.append(scanner.nextLine + System.lineSeparator)
        fileContents.toString
      } finally if (scanner != null) scanner.close()
    }
  }

}