import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Figures.*;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verf�gung, in welchem
 * Figur-Objekte dargestellt werden k�nnen.
 * Siehe auch Java-Grundkurs Abschnitt 10.2 und 10.3.
 * 
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {
  /** Die Liste der dargestellten Figur-Objekte */
  private List<Figure> figures = new ArrayList<Figure>();

  /**
   * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und erzeugt ein
   * JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
   */
  public Display() {
    Dimension windowSize = new Dimension(800, 600);
    setSize(windowSize);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int windowPositionX = (screenSize.width - windowSize.width) / 2;
    int windowPositionY = (screenSize.height - windowSize.height) / 2;
    Point windowPosition = new Point(windowPositionX, windowPositionY);
    setLocation(windowPosition);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    createAndAddDrawingPanel();
    setVisible(true);
  }

  private void createAndAddDrawingPanel() {
    // Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
    // Siehe Java-Grundkurs Abschnitt 3.9
    add(new JPanel() {
      // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
      // Methode beim Dsiplay aufruft.
      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFigures(g);
      }
    });
  }

  /**
   * Zeichnet alle Figuren.
   * @param g Referenz auf das Graphics-Objekt zum zeichnen.
   */
  private void drawFigures(Graphics g) {
    for (Figure f : figures) {
      g.setColor(f.getFillColor());

      if (f instanceof Figures.Rectangle) {
        Figures.Rectangle r = (Figures.Rectangle)f;
        g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
      }

      if (f instanceof Figures.Circle) {
        Figures.Circle c = (Figures.Circle)f;
        g.fillOval(c.getX(), c.getY(), c.getR(), c.getR());
      }

      if (f instanceof Figures.Line) {
        Figures.Line l = (Figures.Line)f;
        g.drawLine(l.getX(), l.getY(), l.getXEnd(), l.getYEnd());
      }

      if (f instanceof Figures.Ellipse) {
        Figures.Ellipse e = (Figures.Ellipse)f;
        g.fillOval(e.getX(), e.getY(), e.getWidth(), e.getHeight());
      }

      /* TODO: Hier muss f�r jede weitere Figur-Klasse, welche dargestellt werden k�nnen muss,
       * ein analoger Abschnitt, wie f�r die Rechteck-Klasse folgen.
       */
    }
  }

  /**
   * F�gt eine weitere Figur hinzu und l�st die Auffrischung des Fensterinhaltes aus.
   * @param figure Referenz auf das weitere Figur-Objekt.
   */
  public void add(Figure figure) {
    figures.add(figure);
    repaint();
  }

  public void add(Figure[] figures) {
    for (Figure figure:
         figures) {
      this.figures.add(figure);
    }
    repaint();
  }

  public Figure[] getFigures(){
    return this.figures.toArray(new Figure[figures.size()]);
  }

  /**
   * L�scht alle Figuren und l�st die Auffrischung des Fensterinhaltes aus.
   */
  public void deleteAll() {
    figures.clear();
    repaint();
  }
}
