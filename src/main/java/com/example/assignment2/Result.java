package com.example.assignment2;

import java.util.StringJoiner;

public class Result {
    private String wrapperType, kind, artistName, collectionName, trackName, artistViewUrl, collectionViewUrl, trackViewUrl, previewUrl, artworkUrl60, releaseDate, trackTimeMillis, country, currency, primaryGenreName;
    private int artistId, collectionId, trackId;
    private double collectionPrice, trackPrice;

    // Variable items
    private String description, shortDescription, longDescription;
    private boolean isStreamable;

    public String getWrapperType() {
        return wrapperType;
    }

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

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public int getTrackId() {
        return trackId;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStreamable() {
        return isStreamable;
    }

    @Override
    public String toString() {

        // Find a better alternative
        if (description != null) {
            description = description.replaceAll("<br />", "\n \t\t\t");
        }

        String resultString = 
                "\t wrapperType='" + wrapperType + "'\n" +
                "\t kind='" + kind + "'\n" +
                "\t artistName='" + artistName + "'\n" +
                "\t collectionName='" + collectionName + "'\n" +
                "\t trackName='" + trackName + "'\n" +
                "\t artistViewUrl='" + artistViewUrl + "'\n" +
                "\t collectionViewUrl='" + collectionViewUrl + "'\n" +
                "\t trackViewUrl='" + trackViewUrl + "'\n" +
                "\t previewUrl='" + previewUrl + "'\n" +
                "\t artworkUrl60='" + artworkUrl60 + "'\n" +
                "\t releaseDate='" + releaseDate + "'\n" +
                "\t trackTimeMillis='" + trackTimeMillis + "'\n" +
                "\t country='" + country + "'\n" +
                "\t currency='" + currency + "'\n" +
                "\t primaryGenreName='" + primaryGenreName + "'\n" +
                "\t artistId=" + artistId + "\n" +
                "\t collectionId=" + collectionId + "\n" +
                "\t trackId=" + trackId + "\n" +
                "\t collectionPrice=" + collectionPrice + "\n" +
                "\t trackPrice=" + trackPrice + "\n" +
                "\t shortDescription='" + shortDescription + "'\n" +
                "\t longDescription='" + longDescription + "'\n" +
                "\t description='" + description + "'\n" +
                "\t isStreamable=" + isStreamable + "\n";
        return resultString;
    }
}
