package Drawing.StoringRestoring.Factories;

import Figures.Figure;

import java.awt.*;

public abstract class Factory {
    public Color parseColor(String colorString) {
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

    public abstract Figure create(String[] parts);
}
