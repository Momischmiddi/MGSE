package gui.bottomcontainer

import java.awt.event.{ActionEvent}
import java.awt.{BorderLayout, Color, Font}

import gui.centercontainer.CenterContainer
import gui.topcontainer.TopContainer
import javax.swing._
import model.Program

case class BottomContainer(topContainer: TopContainer, centerContainer: CenterContainer,
                           program: Program, jf: JFrame) extends JPanel {

  val ratingIcon = new ImageIcon("")
  val labelFont = new Font("Arial", Font.ITALIC, 12)

  val ratingLabel = new JLabel()
  val nextButton = new JButton("Weiter")
  val prevButton = new JButton("Zurück")

  var currentMovieID = 0

  def create() = {
    this.setBackground(Color.WHITE)
    this.setLayout(new BorderLayout())

    ratingLabel.setIcon(ratingIcon)
    nextButton.setFont(labelFont)
    prevButton.setFont(labelFont)

    prevButton.setEnabled(false)


    this.add(ratingLabel, BorderLayout.NORTH)
    this.add(nextButton, BorderLayout.EAST)
    this.add(prevButton, BorderLayout.WEST)

    this.setRatingLabel()

    nextButton.addActionListener((e: ActionEvent) => {
      prevButton.setEnabled(true)

      currentMovieID = currentMovieID + 1

      topContainer.update(program.programs(currentMovieID))
      centerContainer.update(program.programs(currentMovieID))
      update()

      jf.pack()

      if (currentMovieID == program.programs.length - 1) {
        nextButton.setEnabled(false)
      } else {
        nextButton.setEnabled(true)
      }
    })

    prevButton.addActionListener((e: ActionEvent) => {
      nextButton.setEnabled(true)

      currentMovieID = currentMovieID - 1

      topContainer.update(program.programs(currentMovieID))
      centerContainer.update(program.programs(currentMovieID))
      update()

      jf.pack()

      if (currentMovieID == 0) {
        prevButton.setEnabled(false)
      } else {
        prevButton.setEnabled(true)
      }
    })
  }

  def setRatingLabel() = {
    val rating = program.programs(currentMovieID).rating
    val iconPath = "src/main/scala/gui/images/" + rating + ".png"

    ratingLabel.setIcon(new ImageIcon(iconPath))
  }

  def update() = {
    setRatingLabel()
  }

}
