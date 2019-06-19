package gui

import java.awt.{BorderLayout, Color}
import gui.bottomcontainer.BottomContainer
import gui.centercontainer.CenterContainer
import gui.topcontainer.TopContainer
import javax.swing.{ImageIcon, JFrame}
import model.Program

class MainFrame {

  val EXIT_ON_CLOSE = 3
  val APP_ICON = new ImageIcon("src/main/scala/gui/images/Logo.png")

  def createUI(program: Program) = {
    val mainFrame = new JFrame

    setMainFrameProps(mainFrame)
    addComponents(program, mainFrame)

    mainFrame.pack()
    mainFrame.setLocationRelativeTo(null)
  }

  def setMainFrameProps(mainFrame: JFrame) = {
    mainFrame.setBackground(Color.WHITE)
    mainFrame.setLayout(new BorderLayout())
    mainFrame.setVisible(true)
    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE)
    mainFrame.setResizable(false)

    mainFrame.setTitle("Movie-Star")
    mainFrame.setIconImage(APP_ICON.getImage)
  }

  def addComponents(program: Program, mainFrame: JFrame) = {
    val topContainer = new TopContainer()
    val centerContainer = new CenterContainer()
    val bottomContainer = new BottomContainer(topContainer, centerContainer, program, mainFrame)

    topContainer.create(program.programs(0))
    centerContainer.create(program.programs(0))
    bottomContainer.create()

    mainFrame.add(topContainer, BorderLayout.NORTH)
    mainFrame.add(centerContainer, BorderLayout.CENTER)
    mainFrame.add(bottomContainer, BorderLayout.SOUTH)
  }

}