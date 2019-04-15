package Figures;

import java.awt.*;

public abstract class Figure {
    private int x, y;

    private Color fillColor = Color.BLACK;

    protected Figure(int x, int y){
        this.x = x;
        this.y = y;
    }

    protected Figure(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.fillColor = color;
    }

    public int getX(){ return x; }
    public int getY() { return y; }

    //color
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    public Color getFillColor(){
        return this.fillColor;
    }

    //saving
    protected String generateColorString(){
        return  fillColor.getRed() + "," +
                fillColor.getGreen() + "," +
                fillColor.getBlue() + "," +
                fillColor.getAlpha();
    }

    public abstract String generateSavingString();

    //transform
    public void move(int deltaX, int deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }

    //visualisation
    public abstract void draw(Graphics g);
}
