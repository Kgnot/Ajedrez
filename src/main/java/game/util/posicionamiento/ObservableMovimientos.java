package game.util.posicionamiento;

import game.core.logic.Fichas;
import game.util.Observable;
import game.util.Observer;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class ObservableMovimientos implements Observable {
    private Set<Observer> observers = new HashSet<>();
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // Hubo movimiento de una ficha, cual?, me la tienen que pasar
        for(Observer o : observers){
            o.update();
        }

    }
    @Override
    public boolean notify(Observer o) {
        return false;
    }
}
