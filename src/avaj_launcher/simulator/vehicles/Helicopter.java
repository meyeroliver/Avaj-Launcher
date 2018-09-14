package avaj_launcher.simulator.vehicles;

import avaj_launcher.simulator.WeatherTower;
import avaj_launcher.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(coordinates);
        String message;
        switch (weather) {
            case "RAIN":
                message = "Rain. Rain. Go away, Come back another day. Close the off the carriage, we're getting wet.";
                this.updateCoordinates(message, new Coordinates(5,0,0));
                break;
            case "FOG":
                message = "What lies beyond the veil? ...MORE FOG!!!!";
                this.updateCoordinates(message, new Coordinates(1,0, 0));
                break;
            case "SUN":
                message = "THIS IS HOT!";
                this.updateCoordinates(message, new Coordinates(10, 0 , 2));
                break;
            case "SNOW":
                message = "My rotor is going to freeze. Need to land safely";
                this.updateCoordinates(message, new Coordinates(0, 0, -12));
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.landed(this);
            Logger logger = new Logger("simulation.txt", true);
            logger.writeToFile(this.type +"#"+this.name+"("+this.id+") landed");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger logger = new Logger("simulation.txt", true);
        logger.writeToFile("Tower says: " +this.type +"#"+this.name+"("+this.id+") registered to weather tower.");
    }
}
