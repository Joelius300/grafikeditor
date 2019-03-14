package Drawing.StoringRestoring;

import Figures.*;
import Figures.Rectangle;

import java.awt.*;

public class FigureParser {
    public Figure parseFigure(String savedString) throws Exception {
        try{
            String[] parts = savedString.split(";");
            if(parts.length > 0){
                int[] parsedParts;
                switch(parts[0]){
                    case "Rectangle":
                        parsedParts = new int[4];
                        for (int i = 0; i < parsedParts.length; i++) {
                            parsedParts[i] = Integer.parseInt(parts[i+2]);
                        }

                        Rectangle r = new Rectangle(parsedParts[0], parsedParts[1], parsedParts[2], parsedParts[3]);
                        r.setFillColor(parseColor(parts[1]));
                        return r;

                    case "Ellipse":
                        parsedParts = new int[4];
                        for (int i = 0; i < parsedParts.length; i++) {
                            parsedParts[i] = Integer.parseInt(parts[i+2]);
                        }

                        Ellipse e = new Ellipse(parsedParts[0], parsedParts[1], parsedParts[2], parsedParts[3]);
                        e.setFillColor(parseColor(parts[1]));
                        return e;

                    case "Line":
                        parsedParts = new int[4];
                        for (int i = 0; i < parsedParts.length; i++) {
                            parsedParts[i] = Integer.parseInt(parts[i+2]);
                        }

                        Line l = new Line(parsedParts[0], parsedParts[1], parsedParts[2], parsedParts[3]);
                        l.setFillColor(parseColor(parts[1]));
                        return l;

                    case "Circle":
                        parsedParts = new int[3];
                        for (int i = 0; i < parsedParts.length; i++) {
                            parsedParts[i] = Integer.parseInt(parts[i+2]);
                        }

                        Circle c = new Circle(parsedParts[0], parsedParts[1], parsedParts[2]);
                        c.setFillColor(parseColor(parts[1]));
                        return c;

                    default:
                        throw new Exception("Nicht unterstützte Figur");
                }
            }

        }catch (Exception e){}

        throw new Exception("Es gab einen Fehler beim Parsen der Figur.");
    }

    private Color parseColor(String colorString) {
        try {
            String[] parts = colorString.split(",");
            int[] parsedParts = new int[4];
            for (int i = 0; i < parsedParts.length; i++) {
                parsedParts[i] = Integer.parseInt(parts[i]);
            }

            return new Color(parsedParts[0], parsedParts[1], parsedParts[2], parsedParts[3]);
        } catch (Exception e) {
            return Color.BLACK;
        }
    }
}
