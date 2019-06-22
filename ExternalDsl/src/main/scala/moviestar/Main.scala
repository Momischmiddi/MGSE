package moviestar

import java.io.File
import java.util.Scanner
import dsl.{MovieObjectGenerator, StyleObjectGenerator}
import gui.GUI

object Main {

  final var MOVIE_DSL_PATH = "src/main/scala/dsl/Program.Moviestar"
  final var STYLE_DSL_PATH = "src/main/scala/dsl/Style.Style"

  def main(args: Array[String]): Unit = {
    val movieObjectGenerator = new MovieObjectGenerator()
    val styleObjectGenerator = new StyleObjectGenerator()

    val movieDSLfileContent = readFileContent(new File(MOVIE_DSL_PATH))
    val styleDSLfileContent = readFileContent(new File(STYLE_DSL_PATH))

    val program = movieObjectGenerator.generate(movieDSLfileContent)
    val style = styleObjectGenerator.generate(styleDSLfileContent)

    println("Generated program: " + program)
    println("Generated style: " + style)

    new GUI().createUI(program)
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
      } finally {
        if (scanner != null) {
          scanner.close()
        }
      }
    }
  }

}