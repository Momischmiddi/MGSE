package gui.topcontainer

import java.awt.{BorderLayout, Color, FlowLayout}
import gui.generatedGUIComponents.GeneratedMovieInfoLabel
import javax.swing.{JPanel}
import model.ProgramPoint

case class MovieInfoContainer() extends JPanel {

  val dayTimeTitleContainer = new JPanel()
  val dskChannelLenContainer = new JPanel()

  val dayLabel = new GeneratedMovieInfoLabel()
  val timeLabel = new GeneratedMovieInfoLabel()
  val titleLabel = new GeneratedMovieInfoLabel()
  val fskLabel = new GeneratedMovieInfoLabel()
  val channelLabel = new GeneratedMovieInfoLabel()
  val lenLabel = new GeneratedMovieInfoLabel()

  def createUI(programPoint: ProgramPoint): Unit = {
    this.setLayout(new BorderLayout())
    this.setBackground(Color.WHITE)
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