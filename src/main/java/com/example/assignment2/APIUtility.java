package com.example.assignment2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class APIUtility {
    public static void readITunesAPI(String searchText) throws IOException, InterruptedException {
        // Try changing %20 to + in OMDB Jaret example
        searchText = searchText.replaceAll(" ", "%20");
        String uri = "https://itunes.apple.com/search?term="+searchText;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        client.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Paths.get("iSearch.json")));

        HttpResponse<String> responseString = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(responseString);
    }
}
