package avaj_launcher.simulator.vehicles;

import avaj_launcher.weather.Coordinates;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Flyable newFlyable;
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {

            case "Baloon":
                newFlyable = new Baloon(name, coordinates);
                ((Baloon) newFlyable).setType(type);
                break;
            case "JetPlane":
                newFlyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
                ((JetPlane) newFlyable).setType(type);
                break;
            case "Helicopter":
                newFlyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
                ((Helicopter) newFlyable).setType(type);
                break;
            default:
                throw new IllegalArgumentException("This aircraft (" + type +") may not enter this airspace.\n vacate yourself of you will get shot down. \n Choose wisely.");
        }
        return newFlyable;
    }
}