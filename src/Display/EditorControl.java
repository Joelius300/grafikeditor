package Display;

import Drawing.Drawing;
import Drawing.StoringRestoring.Factories.FigureFactory;
import Drawing.StoringRestoring.FigureLoader;
import Drawing.StoringRestoring.FigureSaver;
import Figures.Figure;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

public final class EditorControl {
  private Drawing drawing = new Drawing();

  private final FigureLoader LOADER = new FigureLoader();
  private final FigureSaver SAVER = new FigureSaver();

  private final File SAVEFILE = new File("default.drawing");

  private char figureType;
  private Point firstPoint;

  private final FigureFactory factory = new FigureFactory();
  private final HashMap<Character, String> typeMap = new HashMap<Character, String>(){
    {
      put('r', "Rectangle");
      put('e', "Ellipse");
      put('l', "Line");
      put('c', "Circle");
    }
  };

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
    //create the new object
    try{
      return factory.create(typeMap.get(figureType), firstPoint, secondPoint);
    }catch (Exception e) {
      throw new Exception("Kein richtiger Typ");
    }
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
