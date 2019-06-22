package gui.centercontainer

import java.awt.{Color}

import gui.generatedGUIComponents.GeneratedTextPane
import model.ProgramPoint

import scala.swing.BorderPanel

case class CenterContainer() extends BorderPanel {
  val descriptionTextPane = new GeneratedTextPane()

  def create(programPoint: ProgramPoint) = {
    background = Color.WHITE

    add(descriptionTextPane, BorderPanel.Position.North)
    this.descriptionTextPane.text = this.addLineBreaks(programPoint.description)
  }

  def update(programPoint: ProgramPoint) = {
    this.setImageDescription(programPoint)
  }

  def setImageDescription(programPoint: ProgramPoint) = {
    var imageDescription = programPoint.description
    imageDescription = addLineBreaks(imageDescription)

    descriptionTextPane.text = imageDescription
  }

  def addLineBreaks(imageDescription: String): String = {
    var result = ""

    var lenCounter = 0
    var setNewline = false

    for (c <- imageDescription) {
      result = result + c
      lenCounter = lenCounter + 1

      if (lenCounter % 50 == 0) {
        setNewline = true
      }

      if (c == ' ' && setNewline) {
        result = result + "\n"
        setNewline = false
      }
    }

    result
  }

}