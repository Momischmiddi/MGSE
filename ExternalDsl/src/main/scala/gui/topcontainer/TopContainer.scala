package gui.topcontainer

import java.awt.{Color}

import model.ProgramPoint

import scala.swing.BorderPanel

case class TopContainer() extends BorderPanel {

  val movieInfoContainer = new MovieInfoContainer()
  val imageContainer = new ImageContainer()

  def create(programPoint: ProgramPoint) = {
    background = Color.WHITE

    movieInfoContainer.createUI(programPoint)
    imageContainer.createUI(programPoint)

    add(imageContainer, BorderPanel.Position.North)
    add(movieInfoContainer, BorderPanel.Position.South)
  }

  def update(programPoint: ProgramPoint) = {
    movieInfoContainer.update(programPoint)
    imageContainer.update(programPoint)
  }

}