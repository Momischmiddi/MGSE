package gui.topcontainer

import java.awt.{BorderLayout, Color}
import javax.swing.JPanel
import model.ProgramPoint

case class TopContainer() extends JPanel {

  val movieInfoContainer = new MovieInfoContainer()
  val imageContainer = new ImageContainer()

  def create(programPoint: ProgramPoint) = {
    this.setLayout(new BorderLayout())
    this.setBackground(Color.WHITE)

    movieInfoContainer.createUI(programPoint)
    imageContainer.createUI(programPoint)

    this.add(imageContainer, BorderLayout.NORTH)
    this.add(movieInfoContainer, BorderLayout.SOUTH)
  }

  def update(programPoint: ProgramPoint) = {
    movieInfoContainer.update(programPoint)
    imageContainer.update(programPoint)
  }

}