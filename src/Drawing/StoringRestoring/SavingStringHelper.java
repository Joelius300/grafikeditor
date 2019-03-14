package Drawing.StoringRestoring;

import Figures.*;
import Figures.Rectangle;

import java.awt.*;

public abstract class SavingStringHelper {
    public static String generateSavingString(Figure f) throws Exception {
        if (f instanceof Figures.Rectangle) {
            Figures.Rectangle r = (Figures.Rectangle)f;
            return generateSavingString(r);
        }

        if (f instanceof Figures.Circle) {
            Figures.Circle c = (Figures.Circle)f;
            return generateSavingString(c);
        }

        if (f instanceof Figures.Line) {
            Figures.Line l = (Figures.Line)f;
            return generateSavingString(l);
        }

        if (f instanceof Figures.Ellipse) {
            Figures.Ellipse e = (Figures.Ellipse)f;
            return generateSavingString(e);
        }

        throw new Exception("Nicht unterstützte Figur");
    }

    public static String generateSavingString(Rectangle rectangle){
        return  "Rectangle;" +
                getColorString(rectangle.getFillColor()) + ";" +
                rectangle.getX() + ";" +
                rectangle.getY() + ";" +
                rectangle.getWidth() + ";" +
                rectangle.getHeight();
    }

    public static String generateSavingString(Ellipse ellipse){
        return  "Ellipse;" +
                getColorString(ellipse.getFillColor()) + ";" +
                ellipse.getX() + ";" +
                ellipse.getY() + ";" +
                ellipse.getWidth() + ";" +
                ellipse.getHeight();
    }

    public static String generateSavingString(Circle circle){
        return  "Circle;" +
                getColorString(circle.getFillColor()) + ";" +
                circle.getX() + ";" +
                circle.getY() + ";" +
                circle.getR();
    }

    public static String generateSavingString(Line line){
        return "Line;" +
                getColorString(line.getFillColor()) + ";" +
                line.getX() + ";" +
                line.getY() + ";" +
                line.getXEnd() + ";" +
                line.getYEnd();
    }

    private static String getColorString(Color color){
        return  color.getRed() + "," +
                color.getGreen() + "," +
                color.getBlue() + "," +
                color.getAlpha();
    }
}
