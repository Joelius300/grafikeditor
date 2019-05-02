package Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

@SuppressWarnings("serial")
public final class EditorFrame extends JFrame {
    private EditorControl control;

    public EditorFrame(int width, int height) {
        createJMenu();
        replaceAndSetEditorPanel();
        centerWindow(width, height);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    private void replaceAndSetEditorPanel() {
        control = new EditorControl(this);
        JPanel panel = new EditorPanel(control);

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

    private void createJMenu(){
        JMenuBar bar = new JMenuBar();
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new SaveListener(this));
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(new LoadListener(this));

        bar.add(save);
        bar.add(load);

        super.setJMenuBar(bar);
    }

    private class SaveListener implements ActionListener{
        public JFrame frame;

        public SaveListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            control.promptSaveDrawing();
        }
    }

    private class LoadListener implements ActionListener{
        public JFrame frame;

        public LoadListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            control.promptLoadDrawing();
        }
    }
}
