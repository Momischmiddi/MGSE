package gui

import java.awt.{Color}

import scala.swing._
import _root_.model.Program
import gui.bottomcontainer.BottomContainer
import gui.centercontainer.CenterContainer
import gui.topcontainer.TopContainer
import javax.swing.ImageIcon

class GUI extends MainFrame {

  val APP_ICON = new ImageIcon("src/main/scala/gui/images/Logo.png")

  def createUI(program: Program) = {
    setMainFrameProps()
    addComponents(program)

    pack()
    setLocationRelativeTo(null)
  }

  def setMainFrameProps() = {
    background = Color.WHITE
    visible = true
    resizable = false
    title = "Movie-Star"
    iconImage = APP_ICON.getImage
  }

  def addComponents(program: Program) = {
    val topContainer = new TopContainer()
    val centerContainer = new CenterContainer()
    val bottomContainer = new BottomContainer(topContainer, centerContainer, program, this)

    topContainer.create(program.programs(0))
    centerContainer.create(program.programs(0))
    bottomContainer.create()

    contents = new BorderPanel {
      add(topContainer, BorderPanel.Position.North)
      add(centerContainer, BorderPanel.Position.Center)
      add(bottomContainer, BorderPanel.Position.South)
    }
  }
}
