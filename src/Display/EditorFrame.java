package Display;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.*;

@SuppressWarnings("serial")
public final class EditorFrame extends JFrame {
    public EditorFrame(int width, int height) {
        replaceAndSetEditorPanel();
        centerWindow(width, height);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void replaceAndSetEditorPanel() {
        JPanel panel = new EditorPanel(new EditorControl());
        super.setContentPane(panel);
        panel.setFocusable(true);
        panel.grabFocus();
    }

    private void centerWindow(int width, int height) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle cutout = new Rectangle();
        cutout.width = width;
        cutout.height = height;
        cutout.x = (screenSize.width - cutout.width) / 2;
        cutout.y = (screenSize.height - cutout.height) / 2;
        super.setBounds(cutout);
    }
}
