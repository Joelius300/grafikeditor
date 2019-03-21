package Display;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class EditorFrame extends JFrame {
  private EditorControl editorControl = new EditorControl();
  
  public EditorFrame(int width, int height) {
    replaceAndSetEditorPanel();
    centerWindow(width, height);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void replaceAndSetEditorPanel() {
    JPanel panel = new EditorPanel(editorControl);
    setContentPane(panel);
    panel.setFocusable(true);
    panel.grabFocus();
  }

  private void centerWindow(int width, int height) {
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    Rectangle cutout = new Rectangle();
    cutout.width = width;
    cutout.height = height;
    cutout.x = (size.width - cutout.width) / 2;
    cutout.y = (size.height - cutout.height) / 2;
    setBounds(cutout);
  }
}
