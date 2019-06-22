package gui.bottomcontainer

import java.awt.Color

import gui.GUI
import gui.centercontainer.CenterContainer
import gui.generatedGUIComponents.GeneratedButton
import gui.topcontainer.TopContainer
import javax.swing._
import model.Program

import scala.swing.event.ButtonClicked
import scala.swing.{BorderPanel, Label}

case class BottomContainer(topContainer: TopContainer, centerContainer: CenterContainer,
                           program: Program, mainFrame: GUI) extends BorderPanel {

  val ratingIcon = new ImageIcon("")

  val ratingLabel = new Label()

  val nextButton = new GeneratedButton("Weiter")
  val prevButton = new GeneratedButton("Zurück")

  var currentMovieID = 0

  def handleButtonClick(b: swing.AbstractButton): Unit = {
    if (b.text.equals("Weiter")) {
      handleNextButtonClick()
    } else {
      handlePrevButtonClick()
    }
  }

  def create() = {
    background = Color.WHITE
    ratingLabel.icon = ratingIcon

    prevButton.enabled = false

    this.add(ratingLabel, BorderPanel.Position.North)
    this.add(nextButton, BorderPanel.Position.East)
    this.add(prevButton, BorderPanel.Position.West)

    this.setRatingLabel()

    listenTo(nextButton)
    reactions += {
      case ButtonClicked(b) => handleButtonClick(b)
    }
  }

  def setRatingLabel() = {
    val rating = program.programs(currentMovieID).rating
    val iconPath = "src/main/scala/gui/images/" + rating + ".png"

    ratingLabel.icon = new ImageIcon(iconPath)
  }

  def update() = {
    setRatingLabel()
  }

  def handleNextButtonClick(): Unit = {
    prevButton.enabled = true

    currentMovieID = currentMovieID + 1

    topContainer.update(program.programs(currentMovieID))
    centerContainer.update(program.programs(currentMovieID))
    update()

    mainFrame.pack()

    if (currentMovieID == program.programs.length - 1) {
      nextButton.enabled = false
    } else {
      nextButton.enabled = true
    }
  }

  def handlePrevButtonClick(): Unit = {
    nextButton.enabled = true

    currentMovieID = currentMovieID - 1

    topContainer.update(program.programs(currentMovieID))
    centerContainer.update(program.programs(currentMovieID))
    update()

    mainFrame.pack()

    if (currentMovieID == 0) {
      prevButton.enabled = false
    } else {
      prevButton.enabled = true
    }
  }

}