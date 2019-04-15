package Figures;

import java.awt.*;

public final class Ellipse extends Figure {
    private int width, height;

    public Ellipse(int x, int y, int width, int height){
        super(x, y);

        this.width = width;
        this.height = height;
    }

    public Ellipse(int x, int y, int width, int height, Color color){
        super(x, y, color);

        this.width = width;
        this.height = height;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    @Override
    public void draw(Graphics g){
        g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public String generateSavingString(){
        return this.getClass().getSimpleName() + ";" +
                generateColorString() + ";" +
                this.getX() + ";" +
                this.getY() + ";" +
                this.getWidth() + ";" +
                this.getHeight();
    }
}
