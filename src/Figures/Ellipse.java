package Figures;

public class Ellipse extends Figure {
    private int width, height;

    public Ellipse(int x, int y, int width, int height){
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
