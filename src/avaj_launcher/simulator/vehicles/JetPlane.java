package avaj_launcher.simulator.vehicles;

import avaj_launcher.simulator.WeatherTower;
import avaj_launcher.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {

        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather =this.weatherTower.getWeather(coordinates);
        String message;
        switch (weather) {
            case "RAIN":
                message = "Rain. Rain. Go away, Come back another day. Gotta watch out for lightning";
                this.updateCoordinates(message, new Coordinates(0,5,0));
                break;
            case "FOG":
                message = "Need to clear this fog.";
                this.updateCoordinates(message, new Coordinates(0,1, 0));
                break;
            case "SUN":
                message = "Ladies and Gentleman please enjoy the lovely weather that we have going for the day.";
                this.updateCoordinates(message, new Coordinates(0, 10 , 2));
                break;
            case "SNOW":
                message = "We are currently experience a snow storm. Please remain calm.";
                this.updateCoordinates(message, new Coordinates(0, 0, -7));
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
