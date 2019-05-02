package Drawing.StoringRestoring;

import Drawing.StoringRestoring.Factories.FigureFactory;
import Figures.*;
import Drawing.Drawing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public final class FigureLoader {
    private final FigureFactory factory = new FigureFactory();

    private Figure[] restoreFigures(File file) throws Exception {
        try (Scanner scanner = new Scanner (file)) {
            ArrayList<Figure> figures = new ArrayList<Figure>();

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                //System.out.println(line);
                try{
                    figures.add(factory.create(line));
                }catch (Exception e){
                    System.out.println(e.getMessage() + "\r\n" + line);
                }
            }

            scanner.close();

            Figure[] out = new Figure[figures.size()];
            return figures.toArray(out);
        }catch (FileNotFoundException e){
            System.out.println(file + " nicht gefunden:\n" + e.getMessage());
        }

        throw new Exception("Es gab einen Fehler beim Parsen der Figuren.");
    }

    public Drawing restoreDrawing(File file){
        try {
            return new Drawing(restoreFigures(file));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return new Drawing();
        }
    }
}
