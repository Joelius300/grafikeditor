package Display;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public final class EditorMouseAdapter extends MouseAdapter {
    private final EditorControl control;
    private final EditorPanel panel;

    public EditorMouseAdapter(EditorPanel panel, EditorControl control){
        this.panel = panel;
        this.control = control;
    }

    @Override
    public void mousePressed(MouseEvent arg0){
        control.startShape(arg0.getPoint());
        updatePanel();
    }

    @Override
    public void mouseDragged(MouseEvent arg0){
        control.updateShape(arg0.getPoint());
        updatePanel();
    }

    @Override
    public void mouseReleased(MouseEvent arg0){
        control.endShape(arg0.getPoint());
        updatePanel();
    }

    private void updatePanel(){
        panel.repaint();
        panel.grabFocus();
    }
}
