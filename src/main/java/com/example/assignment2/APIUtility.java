package com.example.assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class APIUtility {

    public static void readITunesApi(String searchText) throws IOException, InterruptedException {
        // Try changing %20 to + in OMDB Jaret example
        searchText = searchText.replaceAll(" ", "%20");
        String uri = "https://itunes.apple.com/search?term=" + searchText + "&limit=200";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        client.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Paths.get("iSearch.json")));

        HttpResponse<String> responseString = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(responseString);
    }

    public static APIResponse getResultFromJson() {
        Gson gson = new Gson();
        APIResponse apiResponse = null;
        try (
                FileReader fileReader = new FileReader("iSearch.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        ) {
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }
}
