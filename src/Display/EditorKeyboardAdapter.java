package Display;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditorKeyboardAdapter extends KeyAdapter {
    private EditorControl control;
    public EditorKeyboardAdapter(EditorControl control){
        this.control = control;
    }

    @Override
    public void keyTyped(KeyEvent arg0){
        control.setFigureType(arg0.getKeyChar());
    }
}
