package Drawing.StoringRestoring.Factories;

import Figures.Figure;

public class FigureFactory {
    public Figure create(String line) throws Exception {
        String[] parts = line.split(";");

        try {
            Factory factory = getCorrespondingFactory(parts[0]);
            return factory.create(parts);
        }catch (Exception e){
            throw new Exception("Es gab einen Fehler beim Parsen der Figur.");
        }
    }

    private Factory getCorrespondingFactory(String identifier) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> c = Class.forName("Drawing.StoringRestoring.Factories." + identifier + "Factory");
        Factory factory =  (Factory)c.newInstance();

        return factory;
    }
}
