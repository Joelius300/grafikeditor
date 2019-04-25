package Drawing.StoringRestoring.Factories;

import Figures.Figure;
import Figures.Rectangle;

import java.awt.*;

public final class RectangleFactory extends Factory {
    @Override
    public Figure create(String[] parts){
        int[] parsedParts = new int[4];
        for (int i = 0; i < parsedParts.length; i++) {
            parsedParts[i] = Integer.parseInt(parts[i+2]);
        }

        Rectangle r = new Rectangle(parsedParts[0], parsedParts[1], parsedParts[2], parsedParts[3]);
        r.setFillColor(parseColor(parts[1]));
        return r;
    }

    @Override
    public Figure create(Point P1, Point P2){
        UsefulDrawingData data = calcUsefulDrawingData(P1, P2);
        return new Rectangle(data.getXLower(), data.getYLower(), data.getWidth(), data.getHeight());
    }
}
