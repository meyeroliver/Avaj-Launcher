package avaj_launcher.simulator.vehicles;

import avaj_launcher.simulator.WeatherTower;

public interface Flyable {

    void updateConditions();
    void registerTower(WeatherTower weatherTower);

}