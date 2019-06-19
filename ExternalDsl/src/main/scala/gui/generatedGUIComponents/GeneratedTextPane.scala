package gui.generatedGUIComponents

import java.awt.Font

import javax.swing.JTextPane
import javax.swing.text.{SimpleAttributeSet, StyleConstants}

class GeneratedTextPane extends JTextPane {

  val textPaneFont = new Font("Arial", Font.ITALIC, 12)

  this.setEditable(false)
  this.setFont(textPaneFont)

  val doc = this.getStyledDocument
  val center = new SimpleAttributeSet()
  StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER)
  doc.setParagraphAttributes(0, doc.getLength(), center, false);
}