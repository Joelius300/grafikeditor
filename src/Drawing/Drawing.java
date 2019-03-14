package Drawing;

import Figures.Figure;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drawing {
    List<Figure> figures = new ArrayList<Figure>();

    public Drawing(Figure[] figures){
        this.add(figures);
    }

    public Drawing(){}

    /**
     * Zeichnet alle Figuren.
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */
    public void drawFigures(Graphics g) {
        for (Figure f : figures) {
            g.setColor(f.getFillColor());
            f.draw(g);
        }
    }

    /**
     * F�gt eine weitere Figur hinzu.
     * @param figure Referenz auf das weitere Figur-Objekt.
     */
    public void add(Figure figure) {
        figures.add(figure);
    }

    public void add(Figure[] figures) {
        for (Figure figure:
                figures) {
            this.figures.add(figure);
        }
    }

    public Figure[] getFigures(){
        return this.figures.toArray(new Figure[figures.size()]);
    }

    /**
     * L�scht alle Figuren.
     */
    public void deleteAll() {
        figures.clear();
    }
}
