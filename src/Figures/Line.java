package Figures;

public class Line extends Figure {
    private int xEnd, yEnd;

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        super(xStart, yStart);

        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public int getXEnd(){
        return xEnd;
    }
    public int getYEnd(){ return yEnd; }


    // 3.2
    @Override
    public void move(int deltaX, int deltaY){
        super.move(deltaX, deltaY);
        this.xEnd += deltaX;
        this.yEnd += deltaY;
    }
}
