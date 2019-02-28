package Figures;

public class Rectangle extends Figure {
    private int width, height;

    public Rectangle(int x, int y, int width, int height){
        super(x, y);

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
