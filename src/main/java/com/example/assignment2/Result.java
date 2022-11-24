package com.example.assignment2;

import javafx.scene.image.Image;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.time.*;
import java.util.concurrent.TimeUnit;

public class Result {
    // I have only kept the usable data members which I may expand later on regarding my projects' use.. like previewUrl and artistViewUrl
    private String kind, artistName, collectionName, trackName, artworkUrl100, releaseDate, trackTimeMillis, country, primaryGenreName;
    private double collectionPrice, trackPrice;
    private boolean isStreamable;

    /**
     * These are all the getter for the instance variables
     * @return - instance variable value
     */

    public String getKind() {
        return kind;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public LocalDate getReleaseDate() {
        Instant instant = Instant.parse(releaseDate);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    public int getTrackTimeMillis() {
        return Integer.parseInt(trackTimeMillis);
    }

    public String getDuration(){
        int milliSeconds = Integer.parseInt(trackTimeMillis);
        Duration duration = Duration.ofMillis(milliSeconds);
        int seconds = duration.toSecondsPart();
        int minutes = duration.toMinutesPart();
        int hours = duration.toHoursPart();
        if(hours > 0)
            return String.format("%d hr %d min %d sec", hours, minutes, seconds);
        else
            return String.format("%d min %d sec", minutes, seconds);
    }

    public String getCountry() {
        return country;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public boolean isStreamable() {
        return isStreamable;
    }

    public String isStreamableString() {
        if(isStreamable)
            return "Yes";
        else
            return "No";
    }

    /**
     * This is the toString method used to get a formatted string version of the object data
     * @return
     */
    @Override
    public String toString() {

        String resultString =
                "\t kind='" + kind + "'\n" +
                "\t artistName='" + artistName + "'\n" +
                "\t collectionName='" + collectionName + "'\n" +
                "\t trackName='" + trackName + "'\n" +
                "\t artworkUrl100='" + artworkUrl100 + "'\n" +
                "\t releaseDate='" + releaseDate + "'\n" +
                "\t trackTimeMillis='" + trackTimeMillis + "'\n" +
                "\t country='" + country + "'\n" +
                "\t primaryGenreName='" + primaryGenreName + "'\n" +
                "\t collectionPrice=" + collectionPrice + "\n" +
                "\t trackPrice=" + trackPrice + "\n" +
                "\t isStreamable=" + isStreamable + "\n";
        return resultString;
    }
}
