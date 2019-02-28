package Figures;

public class Circle extends Figure {
    private int r;

    public Circle(int x, int y, int r){
        super(x, y);
        this.r = r;
    }

    public int getR(){ return r; }
}
