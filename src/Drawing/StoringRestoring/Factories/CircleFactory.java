package Drawing.StoringRestoring.Factories;

import Figures.Circle;
import Figures.Figure;

import java.awt.*;

public final class CircleFactory extends Factory {
    @Override
    public Figure create(String[] parts){
        int[] parsedParts = new int[3];
        for (int i = 0; i < parsedParts.length; i++) {
            parsedParts[i] = Integer.parseInt(parts[i+2]);
        }

        Circle c = new Circle(parsedParts[0], parsedParts[1], parsedParts[2]);
        c.setFillColor(parseColor(parts[1]));
        return c;
    }

    @Override
    public Figure create(Point P1, Point P2){
        UsefulDrawingData data = calcUsefulDrawingData(P1, P2);

        int r = Circle.calcR(data.getWidth(),data.getHeight());
        return new Circle(P1.x - r, P2.y - r, r);
    }
}
