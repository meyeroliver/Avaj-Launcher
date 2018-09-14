package avaj_launcher.simulator;

import avaj_launcher.simulator.vehicles.Aircraft;
import avaj_launcher.simulator.vehicles.AircraftFactory;
import avaj_launcher.simulator.vehicles.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Simulator {

    public static void main(String[] args) {

        ArrayList<Flyable> flyables= new ArrayList<Flyable>();
        WeatherTower weatherTower;
        int simulations;
        String splitter[];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {

                simulations = Integer.parseInt(line.split(" ")[0]);
                   if (simulations < 0) {
                    System.out.println("Invalid simulation count in the file specified.");
                    System.exit(1);
                }

                while ((line = reader.readLine()) != null) {
                    splitter = line.split(" ");
                    flyables.add(AircraftFactory.newAircraft(splitter[0], splitter[1], Integer.parseInt(splitter[2]), Integer.parseInt(splitter[3]), Integer.parseInt(splitter[4])));
                }

                weatherTower = new WeatherTower();
                for (Flyable flyable:flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 0; i < simulations; i++) {
                    weatherTower.changeWeather();
                }

            }else {
                System.out.println("This File does not contain anything. Please ensure file has data.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not open the file specified " + args[0] + ".");
        } catch (IOException e) {
            System.out.println("There was an error with reading the input file " + args[0] + ".");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter in a filename.");
        } catch (NoSuchElementException e) {
            System.out.println("Please ensure the file is in the correct format.");
        } catch (NumberFormatException e) {
            System.out.println("Please ensure that all numbers are in the correct format.");
        }

    }

}