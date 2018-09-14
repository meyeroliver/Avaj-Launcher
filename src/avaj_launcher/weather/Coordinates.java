package avaj_launcher.weather;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {

        return longitude;
    }

    public int getLatitude() {

        return latitude;
    }

    public int getHeight() {

        return height;
    }

    public Coordinates changeLongitude(int value) {
        if (this.longitude + value <= 0)
            this.longitude = 1;
        else
            this.longitude += value;

        return this;
    }

    public Coordinates changeLatitude(int value) {
        if (this.latitude + value <= 0)
            this.latitude = 1;
        else
            this.latitude += value;

        return this;
    }

    public Coordinates changeHeight(int value) {
        if (this.height + value >= 100)
            this.height = 100;
        else if (this.height + value <= 0)
            this.height = 0;
        else
            this.height += value;

        return this;
    }
}

