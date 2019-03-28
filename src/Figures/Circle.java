package Figures;

import java.awt.*;

public final class Circle extends Figure {
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

    @Override
    public void draw(Graphics g){
        g.fillOval(this.getX(), this.getY(), this.getR()*2, this.getR()*2);
    }

    public static int calcR(int width, int height){
        return (int)(Math.sqrt(width*width + height*height) / 2);
    }
}
