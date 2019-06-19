package gui.generatedGUIComponents

import java.awt.{Color, Dimension, Font}
import javax.swing.{BorderFactory, JButton}

class GeneratedButton(buttonText: String) extends JButton {

  /* Font kann automatisch generiert werden mit der Klasse ButtonStyle */
  val buttonFont = new Font("Arial", Font.ITALIC, 20)

  this.setText(buttonText)
  this.setFont(buttonFont)

  /* Kann automatisch generiert werden mit der Klasse ButtonStyle */
  this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1))
  this.setPreferredSize(new Dimension(120, 60))
}