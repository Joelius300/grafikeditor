package Figures;

import java.awt.*;

public class Figure {
    private int x, y;

    private Color fillColor = Color.BLACK;

    protected Figure(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){ return x; }
    public int getY() { return y; }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getFillColor(){
        return this.fillColor;
    }

    public void move(int deltaX, int deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }
}
