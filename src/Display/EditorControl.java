package Display;

import Drawing.Drawing;
import Drawing.StoringRestoring.FigureLoader;
import Drawing.StoringRestoring.FigureSaver;
import Figures.*;
import Figures.Rectangle;

import java.awt.*;
import java.io.File;

public final class EditorControl {
  private Drawing drawing = new Drawing();

  private final FigureLoader LOADER = new FigureLoader();
  private final FigureSaver SAVER = new FigureSaver();

  private final File SAVEFILE = new File("default.drawing");

  private char figureType;
  private Point firstPoint;

  public void repaintAll(Graphics g) {
    drawing.drawFigures(g);
  }

  public void clear(){
    drawing.deleteAll();
  }

  public void setFigureType(char figureType) {
    this.figureType = figureType;
    System.out.println(figureType);
  }

  public void startShape(Point firstPoint) {
    this.firstPoint = firstPoint;
  }

  public void updateShape(Point currentPoint){
    try {
      drawing.setPreviewFigure(createFigure(currentPoint));
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  public void endShape(Point secondPoint) {
    try {
      drawing.removePreviewFigure();
      drawing.add(createFigure(secondPoint));
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  private Figure createFigure(Point secondPoint) throws Exception {
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
        return new Rectangle(xLower, yLower, width, height);
      case 'l':
        return new Line(this.firstPoint, secondPoint);
      case 'c': //janky
        return new Circle(xLower, yLower, Circle.calcR(width,height));
      case 'e':
        return new Ellipse(xLower, yLower, width, height);
    }

    throw new Exception("Kein richtiger Typ");
  }

  public void saveCurrentToFile() {
    SAVER.save(drawing.getFigures(), SAVEFILE);
  }

  public void loadCurrentFromFile() {
    this.drawing = LOADER.restoreDrawing(SAVEFILE);
  }

  public void removeLatestFigure() {
    this.drawing.deleteLatest();
  }
}
