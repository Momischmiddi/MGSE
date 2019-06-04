package test

import java.io.File
import java.util.Scanner

object Test extends MyParser {

  final var filePath = "src/main/scala/test/DSLFile.Scalagame"

  def main(args: Array[String]): Unit = {
    var fileContent = readFileContent(new File(filePath))

    println("Darin: " + fileContent)

    var result = parseAll(floatingPointNumber, "a")
    println(result)
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