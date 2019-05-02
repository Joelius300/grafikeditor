package Drawing;

import Figures.Figure;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Drawing {
    private List<Figure> figures = new ArrayList<Figure>();
    private Figure previewFigure = null;

    private File saveFile = null;

    public File getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(File saveFile) {
        this.saveFile = saveFile;
    }

    public Drawing(Figure[] figures){
        this.add(figures);
    }

    public Drawing(){}

    //draw
    public void drawFigures(Graphics g) {
        for (Figure f : figures) {
            g.setColor(f.getFillColor());
            f.draw(g);
        }

        if(previewFigure != null){
            g.setColor(adjustAlpha(previewFigure.getFillColor(), 0.8f));
            previewFigure.draw(g);
        }
    }

    private Color adjustAlpha(Color color, float percent){
        int a = color.getAlpha();
        a *= percent;
        if(a > 255) a = 255;
        if(a < 0) a = 0;

        return new Color(color.getRed(), color.getGreen(), color.getBlue(), a);
    }

    //preview
    public void setPreviewFigure(Figure figure){ previewFigure = figure; }
    public void removePreviewFigure(){ previewFigure = null; }

    //add
    public void add(Figure figure) {
        figures.add(figure);
    }

    public void add(Figure[] figures) {
        for (Figure figure:
                figures) {
            this.figures.add(figure);
        }
    }

    //get
    public Figure[] getFigures(){
        return this.figures.toArray(new Figure[figures.size()]);
    }

    //delete
    public void deleteAll() {
        figures.clear();
    }

    public void deleteFigure(Figure figure){
        if(figures.contains(figure)) figures.remove(figure);
    }

    public void deleteLatest(){
        if(figures.size() > 0) {
            figures.remove(figures.size() - 1);
        }
    }
}
