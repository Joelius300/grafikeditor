package Display;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class EditorKeyboardAdapter extends KeyAdapter {
    private EditorControl control;
    private EditorPanel panel;

    private boolean keyAlreadyHandled;

    public EditorKeyboardAdapter(EditorPanel panel, EditorControl control){
        this.panel = panel;
        this.control = control;
    }

    @Override
    public void keyTyped(KeyEvent arg0){
        if(!keyAlreadyHandled) {
            control.setFigureType(arg0.getKeyChar());
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0){
        keyAlreadyHandled = false;

        if(handleSpecialKeys(arg0)){
            keyAlreadyHandled = true;
            panel.repaint();
        }
    }

    private boolean handleSpecialKeys(KeyEvent e){
        int k = e.getKeyCode();

        if(k == KeyEvent.VK_DELETE){
            control.clear();
            return true;
        }

        return false;
    }
}
