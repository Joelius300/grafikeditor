package Display;

import Drawing.Drawing;
import Drawing.StoringRestoring.Factories.FigureFactory;
import Drawing.StoringRestoring.FigureLoader;
import Drawing.StoringRestoring.FigureSaver;
import Figures.Figure;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;

public final class EditorControl {
  private Drawing drawing = new Drawing();

  private JFrame parentFrame;

  public EditorControl(JFrame parentFrame){
    this.parentFrame = parentFrame;
  }

  private final FigureLoader LOADER = new FigureLoader();
  private final FigureSaver SAVER = new FigureSaver();

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

  public void saveCurrentDrawing(boolean prompt) {
    File file = drawing.getSaveFile();
    if(file == null){
      if(!prompt) return;
      promptSaveDrawing();
    }else{
      SAVER.save(drawing.getFigures(), file);
    }
  }

  public void promptLoadDrawing() {
    FileDialog fd = new FileDialog(parentFrame, "Laden Sie Ihre Zeichung", FileDialog.LOAD);
    fd.setDirectory("C:\\");
    fd.setFile("drawing.txt");
    fd.setVisible(true);

    if (fd.getFile() == null || fd.getFile().isEmpty()) return;

    String path = fd.getDirectory() + fd.getFile();
    File file = new File(path);
    loadDrawing(file);
    drawing.setSaveFile(file);
    parentFrame.repaint();
  }

  public void promptSaveDrawing() {
    FileDialog fd = new FileDialog(parentFrame, "Speichern Sie Ihre Zeichung", FileDialog.SAVE);
    fd.setDirectory("C:\\");
    fd.setFile("drawing.txt");
    fd.setVisible(true);

    if (fd.getFile() == null || fd.getFile().isEmpty()) return;

    String path = fd.getDirectory() + fd.getFile();
    File file = new File(path);
    drawing.setSaveFile(file);
    saveCurrentDrawing(false);
  }

  private void loadDrawing(File file) {
    this.drawing = LOADER.restoreDrawing(file);
  }

  public void removeLatestFigure() {
    this.drawing.deleteLatest();
  }
}
