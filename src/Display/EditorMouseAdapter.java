package Display;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class EditorMouseAdapter extends MouseAdapter {
    EditorControl control;
    EditorPanel panel;

    public EditorMouseAdapter(EditorPanel panel, EditorControl control){
        this.panel = panel;
        this.control = control;
    }

    @Override
    public void mousePressed(MouseEvent arg0){
        control.setFirstPoint(arg0.getPoint());
        panel.repaint();
        panel.grabFocus();
    }

    @Override
    public void mouseReleased(MouseEvent arg0){
        control.createFigureWithSecondPoint(arg0.getPoint());
        panel.repaint();
        panel.grabFocus();
    }
}
