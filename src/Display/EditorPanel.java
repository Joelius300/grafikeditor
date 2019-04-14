package Display;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class EditorPanel extends JPanel {
  private EditorControl editorControl;

  EditorPanel(EditorControl control) {
    editorControl = control;
    MouseListener mouseListener = new EditorMouseAdapter(this, editorControl);
    super.addMouseListener(mouseListener);
    super.addMouseMotionListener((MouseMotionListener)mouseListener);
    super.addKeyListener(new EditorKeyboardAdapter(this, editorControl));
  }

  // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
  // Methode beim EditorFrame oder beim EditorPanel aufruft.
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    editorControl.repaintAll(g);
  }
}