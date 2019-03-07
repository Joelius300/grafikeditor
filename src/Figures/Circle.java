package Figures;

import java.awt.*;

public class Circle extends Figure {
    private int r;

    public Circle(int x, int y, int r){
        super(x, y);
        this.r = r;
    }

    public Circle(int x, int y, int r, Color color){
        super(x, y, color);
        this.r = r;
    }

    public int getR(){ return r; }
}
