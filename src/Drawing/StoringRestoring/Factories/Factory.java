package Drawing.StoringRestoring.Factories;

import Figures.Figure;

import java.awt.*;

public abstract class Factory {
    protected Color parseColor(String colorString) {
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

    protected UsefulDrawingData calcUsefulDrawingData(Point P1, Point P2){
        //Calc values which are useful for creating the new objects
        int xLower, yLower, xHigher, yHigher;

        if(P1.x < P2.x){
            xLower = P1.x;
            xHigher = P2.x;
        }else{
            xHigher = P1.x;
            xLower = P2.x;
        }

        if(P1.y < P2.y){
            yLower = P1.y;
            yHigher = P2.y;
        }else{
            yHigher = P1.y;
            yLower = P2.y;
        }

        int width = xHigher - xLower;
        int height = yHigher - yLower;

        return new UsefulDrawingData(xLower, yLower, width, height);
    }

    public abstract Figure create(String[] parts);
    public abstract Figure create(Point P1, Point P2);

    protected final class UsefulDrawingData{
        private int xLower, yLower, width, height;

        public UsefulDrawingData(int xLower, int yLower, int width, int height) {
            this.xLower = xLower;
            this.yLower = yLower;
            this.width = width;
            this.height = height;
        }

        public int getXLower() {
            return xLower;
        }

        public int getYLower() {
            return yLower;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString(){
            return "X-Low: " + xLower + ", Y-Low: " + yLower + ", Width: " + width + ", Height: " + height;
        }
    }
}
