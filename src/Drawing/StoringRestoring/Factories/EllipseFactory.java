package Drawing.StoringRestoring.Factories;

import Figures.Ellipse;
import Figures.Figure;

import java.awt.*;

public final class EllipseFactory extends Factory {
    @Override
    public Figure create(String[] parts){
        int[] parsedParts = new int[4];
        for (int i = 0; i < parsedParts.length; i++) {
            parsedParts[i] = Integer.parseInt(parts[i+2]);
        }

        final Ellipse e = new Ellipse(parsedParts[0], parsedParts[1], parsedParts[2], parsedParts[3]);
        e.setFillColor(parseColor(parts[1]));
        return e;
    }

    @Override
    public Figure create(Point P1, Point P2){
        final UsefulDrawingData data = calcUsefulDrawingData(P1, P2);
        return new Ellipse(data.getXLower(), data.getYLower(), data.getWidth(), data.getHeight());
    }
}
