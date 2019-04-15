package Figures;

import java.awt.*;

public final class Line extends Figure {
    private int xEnd, yEnd;

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        super(xStart, yStart);

        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public Line(Point firstPoint, Point secondPoint, Color color){
        super(firstPoint.x, firstPoint.y, color);
        this.xEnd = secondPoint.x;
        this.yEnd = secondPoint.y;
    }

    public Line(Point firstPoint, Point secondPoint){
        super(firstPoint.x, firstPoint.y);
        this.xEnd = secondPoint.x;
        this.yEnd = secondPoint.y;
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd, Color color) {
        super(xStart, yStart, color);

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

    @Override
    public void draw(Graphics g){
        g.drawLine(this.getX(), this.getY(), this.getXEnd(), this.getYEnd());
    }

    @Override
    public String generateSavingString(){
        return this.getClass().getSimpleName() + ";" +
                generateColorString() + ";" +
                this.getX() + ";" +
                this.getY() + ";" +
                this.getXEnd() + ";" +
                this.getYEnd();
    }
}
