import Figures.*;
import Figures.Rectangle;
import StoringRestoring.FigureLoader;
import StoringRestoring.FigureSaver;

import java.awt.*;
import java.io.File;

public class Main {
    private static final Display display = new Display();

    public static void main(String[] args){
        display.add(new Rectangle(10, 30, 10, 40));
        display.add(new Circle(30, 50, 10));
        display.add(new Line(5, 5, 30, 40));
        display.add(new Ellipse(100, 100, 30, 40));

        // 3.2 & 1.5
        Line l = new Line(100, 200, 400, 350);
        l.setFillColor(Color.RED);
        l.move(100, 100);
        display.add(l);

        Figure f = new Line(100, 200, 400, 350);
        f.setFillColor(Color.BLUE);
        f.move(100, 100);
        f.move(100, 0);
        display.add(f);

        FigureSaver saver = new FigureSaver();
        saver.Save(display.getFigures(), new File("testSave.txt"));

        display.deleteAll();

        FigureLoader loader = new FigureLoader();
        try {
            display.add(loader.restore(new File("testSave.txt")));
        }catch (Exception e){
            System.out.println("Konnte nicht zurückladen.");
        }
    }
}
