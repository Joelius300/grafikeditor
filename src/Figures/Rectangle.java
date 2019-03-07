package Figures;

import java.awt.*;

public class Rectangle extends Figure {
    private int width, height;

    public Rectangle(int x, int y, int width, int height){
        super(x, y);

        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height, Color color){
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
}
