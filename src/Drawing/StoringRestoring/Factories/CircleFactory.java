package Drawing.StoringRestoring.Factories;

import Figures.Circle;
import Figures.Figure;

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
}
