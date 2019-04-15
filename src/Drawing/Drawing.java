package Drawing;

import Figures.Figure;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<Figure> figures = new ArrayList<Figure>();
    private Figure previewFigure = null;

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
            g.setColor(previewFigure.getFillColor());
            previewFigure.draw(g);
        }
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
