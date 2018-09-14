package avaj_launcher.weather;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "SUN", "FOG", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {

        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        Random rand = new Random();

        int  variance = rand.nextInt(50) + 1;
        int select =  (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() + variance) % 4;
        return weather[select];
    }
}
