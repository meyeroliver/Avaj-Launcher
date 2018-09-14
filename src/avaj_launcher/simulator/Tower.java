package avaj_launcher.simulator;

import avaj_launcher.simulator.vehicles.Flyable;
import java.util.ArrayList;


public abstract class Tower {

    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> landed =  new ArrayList<>();

    public void register(Flyable flyable) {

       observers.add(flyable);
    }

    public void unregister(Flyable flyable) {

        observers.remove(flyable);
    }

    public void landed(Flyable flyable) {

        landed.add(flyable);
    }

    protected void conditionsChanges() {

        for (Flyable flyable: this.getObservers()) {
            flyable.updateConditions();
        }
        for (Flyable flyable : landed) {
            observers.remove(flyable);
        }
    }

    public ArrayList<Flyable> getObservers() {
        return observers;
    }
}
