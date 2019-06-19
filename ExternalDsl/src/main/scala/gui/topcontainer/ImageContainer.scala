package gui.topcontainer

import java.awt.{Color, Dimension, Image}
import java.net.URL

import javax.imageio.ImageIO

import javax.swing.{ImageIcon, JLabel, JPanel}
import model.ProgramPoint

case class ImageContainer() extends JPanel {

  var movieImage = new ImageIcon("").getImage.getScaledInstance(250, 250, Image.SCALE_DEFAULT)
  val imageLabel = new JLabel()

  def createUI(programPoint: ProgramPoint): Unit = {
    this.add(imageLabel)
    this.setBackground(Color.WHITE)
    imageLabel.setPreferredSize(new Dimension(250, 250))

    this.setImage(programPoint)
  }

  def update(programPoint: ProgramPoint) = {
    setImage(programPoint)
  }

  def setImage(programPoint: ProgramPoint) = {
    movieImage = loadImageFromUrl(programPoint.image).getScaledInstance(250, 250, Image.SCALE_DEFAULT)
    imageLabel.setIcon(new ImageIcon(movieImage))
  }

  def loadImageFromUrl(imageURL: String): Image = {
    val url = new URL(imageURL)
    val conn = url.openConnection
    val in = conn.getInputStream

    ImageIO.read(in)
  }

}