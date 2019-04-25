package Drawing.StoringRestoring.Factories;

import Figures.Figure;

import java.awt.*;
import java.util.HashMap;

public final class FigureFactory {
    private final HashMap<String, Factory> _factoryCache = new HashMap<String, Factory>();

    public Figure create(String line) throws Exception {
        String[] parts = line.split(";");

        try {
            Factory factory = getCorrespondingFactory(parts[0]);
            return factory.create(parts);
        }catch (Exception e){
            throw new Exception("Es gab einen Fehler beim Parsen der Figur.");
        }
    }

    public Figure create(String identifier, Point P1, Point P2) throws Exception {
        try {
            return getCorrespondingFactory(identifier).create(P1, P2);
        }catch (Exception e){
            throw new Exception("Es gab einen Fehler beim Parsen der Figur.");
        }
    }

    private Factory getCorrespondingFactory(String identifier) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Factory factory;

        if (_factoryCache.containsKey(identifier)) {
            factory = _factoryCache.get(identifier);
            if(factory != null) {
                //Factory from Cache
                return factory;
            }
        }

        Class<?> c = Class.forName("Drawing.StoringRestoring.Factories." + identifier + "Factory");
        factory =  (Factory)c.newInstance();
        _factoryCache.put(identifier, factory);

        //New factory
        return factory;
    }
}
