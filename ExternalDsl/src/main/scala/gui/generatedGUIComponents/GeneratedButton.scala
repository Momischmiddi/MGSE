package gui.generatedGUIComponents

import java.awt.{Color, Dimension, Font}

import javax.swing.{BorderFactory, JButton}

import scala.swing.Button

class GeneratedButton(buttonText: String) extends Button {

  /* Font kann automatisch generiert werden mit der Klasse ButtonStyle */
  val buttonFont = new Font("Arial", Font.ITALIC, 20)

  this.text = buttonText
  this.font = buttonFont

  /* Kann automatisch generiert werden mit der Klasse ButtonStyle */
  this.border = BorderFactory.createLineBorder(Color.BLACK, 1)
  this.preferredSize = new Dimension(120, 60)
}