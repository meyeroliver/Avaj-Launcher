package avaj_launcher.simulator.vehicles;

import avaj_launcher.simulator.WeatherTower;
import avaj_launcher.weather.Coordinates;;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }


    @Override
    public void updateConditions() {

        String weather = this.weatherTower.getWeather(coordinates);
        String message;
       switch (weather) {
           case "RAIN":
               message = "Rain. Rain. Go away, Come back another day. RAIN! YOU MESSING UP MY BALOON!";
               this.updateCoordinates(message, new Coordinates(0,0,-5));
               break;
           case "FOG":
               message = "A mysterious creature lies beyond the fog. OH MY GAWWWWWWD! I'M GOING DOWN!";
               this.updateCoordinates(message, new Coordinates(0,0, -3));
               break;
           case "SUN":
               message = "Sun's out. It's the most beautiful time of the year. Grab your camera phones, take some selfies.";
               this.updateCoordinates(message, new Coordinates(2, 0 , 4));
               break;
           case "SNOW":
               message = "IT'S SNOWING. WE'RE CRASHING.";
               this.updateCoordinates(message, new Coordinates(0, 0, -15));
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
        /**
         * find a way to use a singleton for the logger class// make logger a singleton
         */

        Logger logger = new Logger("simulation.txt", true);
        logger.writeToFile("Tower says: " +this.type +"#"+this.name+"("+this.id+") registered to weather tower.");
    }
}
