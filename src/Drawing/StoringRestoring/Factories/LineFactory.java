package Drawing.StoringRestoring.Factories;

import Figures.Figure;
import Figures.Line;

public final class LineFactory extends Factory {
    @Override
    public Figure create(String[] parts){
        int[] parsedParts = new int[4];
        for (int i = 0; i < parsedParts.length; i++) {
            parsedParts[i] = Integer.parseInt(parts[i+2]);
        }

        Line l = new Line(parsedParts[0], parsedParts[1], parsedParts[2], parsedParts[3]);
        l.setFillColor(parseColor(parts[1]));
        return l;
    }
}
