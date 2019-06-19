package gui.centercontainer

import java.awt.{BorderLayout, Color, Font}

import gui.generatedGUIComponents.GeneratedTextPane
import javax.swing.text.{SimpleAttributeSet, StyleConstants}
import javax.swing.{JPanel, JTextPane}
import model.ProgramPoint

case class CenterContainer() extends JPanel {
  val descriptionTextPane = new GeneratedTextPane()

  def create(programPoint: ProgramPoint) = {
    this.setLayout(new BorderLayout())
    this.setBackground(Color.WHITE)

    this.add(descriptionTextPane, BorderLayout.NORTH)

    this.descriptionTextPane.setText(this.addLineBreaks(programPoint.description))
  }

  def update(programPoint: ProgramPoint) = {
    this.setImageDescription(programPoint)
  }

  def setImageDescription(programPoint: ProgramPoint) = {
    var imageDescription = programPoint.description
    imageDescription = addLineBreaks(imageDescription)

    descriptionTextPane.setText(imageDescription)
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
