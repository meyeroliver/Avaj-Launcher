package avaj_launcher.simulator.vehicles;

import avaj_launcher.weather.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    private long nextId() {

        this.id = ++idCounter;
        return  this.id;
    }

    protected Aircraft(String name, Coordinates coordinates) {

        this.name = name;
        this.coordinates = coordinates;
        this.nextId();
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


    protected void updateCoordinates(String message, Coordinates coordinates) {

        Logger logger = new Logger("simulation.txt", true);
        logger.writeToFile(this.type +"#"+this.name+"("+this.id+"): " + message);

        this.coordinates.changeLongitude(coordinates.getLongitude());
        this.coordinates.changeLatitude(coordinates.getLatitude());
        this.coordinates.changeHeight(coordinates.getHeight());
    }
}
