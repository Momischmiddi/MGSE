package gui.topcontainer

import java.awt.{Color, Dimension, Image}
import java.net.URL

import javax.imageio.ImageIO
import javax.swing.ImageIcon
import model.ProgramPoint

import scala.swing.{BorderPanel, Label}

case class ImageContainer() extends BorderPanel {

  var movieImage = new ImageIcon("").getImage.getScaledInstance(250, 250, Image.SCALE_DEFAULT)
  val imageLabel = new Label()

  def createUI(programPoint: ProgramPoint): Unit = {
    this.add(imageLabel, BorderPanel.Position.Center)
    background = Color.WHITE
    preferredSize = new Dimension(250, 250)

    this.setImage(programPoint)
  }

  def update(programPoint: ProgramPoint) = {
    setImage(programPoint)
  }

  def setImage(programPoint: ProgramPoint) = {
    movieImage = loadImageFromUrl(programPoint.image).getScaledInstance(250, 250, Image.SCALE_DEFAULT)
    imageLabel.icon = new ImageIcon(movieImage)
  }

  def loadImageFromUrl(imageURL: String): Image = {
    val url = new URL(imageURL)
    val conn = url.openConnection
    val in = conn.getInputStream

    ImageIO.read(in)
  }

}