import Drawing.Drawing;
import Figures.*;
import Figures.Rectangle;
import Drawing.StoringRestoring.FigureLoader;
import Drawing.StoringRestoring.FigureSaver;

import java.awt.*;
import java.io.File;

public class Main {
    private static final Display display = new Display();

    public static void main(String[] args){
        Drawing drawing1 = new Drawing();
        drawing1.add(new Rectangle(10, 30, 10, 40, Color.RED));
        drawing1.add(new Circle(30, 50, 10, Color.BLUE));
        drawing1.add(new Line(5, 5, 30, 40, Color.YELLOW));
        drawing1.add(new Ellipse(100, 100, 30, 40, Color.PINK));

        // 3.2 & 1.5
        Line l = new Line(100, 200, 400, 350);
        l.setFillColor(Color.RED);
        drawing1.add(l);
        l.move(100, 100);

        Figure f = new Line(100, 200, 400, 350);
        f.setFillColor(Color.BLUE);
        drawing1.add(f);
        f.move(100, 100);


        FigureSaver saver = new FigureSaver();
        saver.Save(drawing1.getFigures(), new File("drawing1.txt"));

        display.clear();

        FigureLoader loader = new FigureLoader();
        try {
            Drawing drawing2 = loader.restoreDrawing(new File("drawing1.txt"));
            display.setDrawing(drawing2);
        }catch (Exception e){
            System.out.println("Konnte nicht zurückladen.");
        }
    }
}
