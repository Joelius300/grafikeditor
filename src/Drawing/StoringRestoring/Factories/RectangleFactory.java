package Drawing.StoringRestoring.Factories;

import Figures.Figure;
import Figures.Rectangle;

public class RectangleFactory extends Factory {
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
}
