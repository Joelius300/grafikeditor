package Drawing.StoringRestoring;

import Figures.Figure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class FigureSaver {
    public void save(Figure figure, File file){
        try
        (BufferedWriter myWriter = new BufferedWriter(new FileWriter(file, false)))
        {
            try{
                myWriter.write(figure.generateSavingString());
                myWriter.write("\n");
            }catch (Exception e){
                System.out.println("Figur konnte nicht gespeichert werden. (" + figure.toString() + ")");
            }

        }catch(IOException e){
            System.out.println("Figur konnten nicht gespeichert werden:\n" + e.getMessage());
        }
    }

    public void save(Figure[] figures, File file){
        try
        (BufferedWriter myWriter = new BufferedWriter(new FileWriter(file, false)))
        {
            for (int i = 0; i < figures.length; i++) {
                try{
                    myWriter.write(figures[i].generateSavingString());
                    myWriter.write("\n");
                }catch (Exception e){
                    System.out.println("Figur konnte nicht gespeichert werden. (" + figures[i].toString() + ")");
                }
            }
        }catch(IOException e){
            System.out.println("Figuren konnten nicht gespeichert werden:\n" + e.getMessage());
        }
    }
}
