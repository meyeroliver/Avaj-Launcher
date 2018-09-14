package avaj_launcher.simulator.vehicles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private String filePath;
    private boolean toAppend = false;

    public Logger(String filePath) {
        this.filePath = filePath;
    }

    public Logger(String filePath, boolean toAppend) {
        this.filePath = filePath;
        this.toAppend = toAppend;
    }

    public void writeToFile(String message) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath, toAppend);
            PrintWriter printWriter = new PrintWriter(writer);

            printWriter.println(message);
        } catch (IOException e) {
            System.out.println("Unfortunately the file could not be written into.");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while attempting to close the file. ");
            }
        }



    }
}
