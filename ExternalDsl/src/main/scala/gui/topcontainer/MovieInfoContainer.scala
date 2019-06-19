package gui.topcontainer

import java.awt.{BorderLayout, Color, FlowLayout, Font}

import javax.swing.{JLabel, JPanel}
import model.ProgramPoint

case class MovieInfoContainer() extends JPanel {

  val dayTimeTitleContainer = new JPanel()
  val dskChannelLenContainer = new JPanel()

  val labelFont = new Font("Arial", Font.BOLD, 16)

  val dayLabel = new JLabel()
  val timeLabel = new JLabel()
  val titleLabel = new JLabel()
  val fskLabel = new JLabel()
  val channelLabel = new JLabel()
  val lenLabel = new JLabel()

  def createUI(programPoint: ProgramPoint): Unit = {
    this.setLayout(new BorderLayout())
    this.setBackground(Color.WHITE)
    this.setFonts()
    this.setLabelTexts(programPoint)
    this.addComponents()

    dayTimeTitleContainer.setBackground(Color.WHITE)
    dayTimeTitleContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
    dskChannelLenContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
    dskChannelLenContainer.setBackground(Color.WHITE)
  }

  def addComponents() = {
    dayTimeTitleContainer.add(dayLabel)
    dayTimeTitleContainer.add(timeLabel)
    dayTimeTitleContainer.add(titleLabel)

    dskChannelLenContainer.add(fskLabel)
    dskChannelLenContainer.add(channelLabel)
    dskChannelLenContainer.add(lenLabel)

    this.add(dayTimeTitleContainer, BorderLayout.NORTH)
    this.add(dskChannelLenContainer, BorderLayout.SOUTH)
  }

  def setFonts() = {
    dayLabel.setFont(labelFont)
    timeLabel.setFont(labelFont)
    titleLabel.setFont(labelFont)
    fskLabel.setFont(labelFont)
    channelLabel.setFont(labelFont)
    lenLabel.setFont(labelFont)
  }

  def update(programPoint: ProgramPoint) = {
    setLabelTexts(programPoint)
  }

  def setLabelTexts(programPoint: ProgramPoint) = {
    dayLabel.setText(programPoint.weekday)
    timeLabel.setText(programPoint.time)
    titleLabel.setText(programPoint.title)
    fskLabel.setText("FSK: " + programPoint.fsk.toString)
    channelLabel.setText(programPoint.channel)
    lenLabel.setText(programPoint.filmLength.toString + " Minuten")
  }

}