package gui.topcontainer

import java.awt.Color

import gui.generatedGUIComponents.GeneratedMovieInfoLabel
import model.ProgramPoint

import scala.swing.{BorderPanel, FlowPanel}

case class MovieInfoContainer() extends BorderPanel {

  val dayTimeTitleContainer = new FlowPanel()
  val fskChannelLenContainer = new FlowPanel()

  dayTimeTitleContainer.vGap = 10
  dayTimeTitleContainer.hGap = 20
  fskChannelLenContainer.vGap = 10
  fskChannelLenContainer.hGap = 20

  val dayLabel = new GeneratedMovieInfoLabel()
  val timeLabel = new GeneratedMovieInfoLabel()
  val titleLabel = new GeneratedMovieInfoLabel()
  val fskLabel = new GeneratedMovieInfoLabel()
  val channelLabel = new GeneratedMovieInfoLabel()
  val lenLabel = new GeneratedMovieInfoLabel()

  def createUI(programPoint: ProgramPoint): Unit = {
    background = Color.WHITE
    this.setLabelTexts(programPoint)
    this.addComponents()

    dayTimeTitleContainer.background = Color.WHITE
    fskChannelLenContainer.background = Color.WHITE
  }

  def addComponents() = {
    dayTimeTitleContainer.contents += dayLabel
    dayTimeTitleContainer.contents += timeLabel
    dayTimeTitleContainer.contents += titleLabel

    fskChannelLenContainer.contents += fskLabel
    fskChannelLenContainer.contents += channelLabel
    fskChannelLenContainer.contents += lenLabel

    add(dayTimeTitleContainer, BorderPanel.Position.North)
    add(fskChannelLenContainer, BorderPanel.Position.South)
  }

  def update(programPoint: ProgramPoint) = {
    setLabelTexts(programPoint)
  }

  def setLabelTexts(programPoint: ProgramPoint) = {
    dayLabel.text = programPoint.weekday
    timeLabel.text = programPoint.time
    titleLabel.text = programPoint.title
    fskLabel.text = "FSK: " + programPoint.fsk.toString
    channelLabel.text = programPoint.channel
    lenLabel.text = programPoint.filmLength.toString + " Minuten"
  }

}