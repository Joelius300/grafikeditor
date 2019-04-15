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
        boolean isCtrlDown = (e.getModifiers() & KeyEvent.CTRL_MASK) != 0;

        //clear drawing
        if(k == KeyEvent.VK_DELETE){
            control.clear();
            return true;
        }

        //save drawing (fixed file)
        if(k == KeyEvent.VK_S && isCtrlDown){
            control.saveCurrentToFile();
            return true;
        }

        //load drawing (fixed file)
        if(k == KeyEvent.VK_L && isCtrlDown){
            control.loadCurrentFromFile();
            return true;
        }

        //delete latest figure in drawing
        if(k == KeyEvent.VK_Z && isCtrlDown){
            control.removeLatestFigure();
            return true;
        }

        return false;
    }
}
