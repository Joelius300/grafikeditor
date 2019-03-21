package Display;

import Drawing.Drawing;
import Figures.Circle;
import Figures.Figure;
import Figures.Line;
import Figures.Rectangle;

import java.awt.*;

public final class EditorControl {
  private Drawing drawing = new Drawing();
  private char figureType;
  private Point firstPoint;

  public void repaintAll(Graphics g) {
    drawing.drawFigures(g);
  }

  public void setFigureType(char figureType) {
    this.figureType = figureType;
    System.out.println(figureType);
  }

  public void setFirstPoint(Point firstPoint) {
    this.firstPoint = firstPoint;
  }

  public void createFigureWithSecondPoint(Point secondPoint) {
    int xLower, yLower, xHigher, yHigher;

    if(firstPoint.x < secondPoint.x){
      xLower =  firstPoint.x;
      xHigher = secondPoint.x;
    }else{
      xHigher =  firstPoint.x;
      xLower = secondPoint.x;
    }

    if(firstPoint.y < secondPoint.y){
      yLower =  firstPoint.y;
      yHigher = secondPoint.y;
    }else{
      yHigher =  firstPoint.y;
      yLower = secondPoint.y;
    }

    int width = xHigher - xLower;
    int height = yHigher - yLower;

    switch (figureType){
      case 'r':
        //gut
        Figure r = new Rectangle(xLower, yLower, width, height);
        this.drawing.add(r);
        break;
      case 'l':
        //gut
        Figure l = new Line(this.firstPoint, secondPoint);
        this.drawing.add(l);
        break;
      case 'c':
        //noch nicht gut
        Figure c = new Circle(xLower, yLower, width);
        this.drawing.add(c);
        break;
        default:
          System.out.println("Keine richtiger Typ");
          break;
    }
  }
}
