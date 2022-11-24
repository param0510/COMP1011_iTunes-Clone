package com.example.assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This is the iTunes API reader method where we request for json data by sending HttpRequest to the iTunes API
     * @param searchText - This is the character(s) searched by the user to request data from the API accordingly
     * @throws IOException
     * @throws InterruptedException
     */
    public static void readITunesApi(String searchText) throws IOException, InterruptedException {
        // Try changing %20 to + in OMDB Jaret example
        searchText = searchText.replaceAll(" ", "%20");
        // Preparing the uri for the API request call
        String uri = "https://itunes.apple.com/search?term=" + searchText + "&media=music&limit=200";

        // Preparing the web client - like a browser for firing the uri
        HttpClient client = HttpClient.newHttpClient();

        // Generating a HttpRequest using the uri
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

//         Clears the file before it is overwritten in the next step.
        new FileWriter("iSearch.json", false).close();

        // Sending the HttpRequest through the browser client and storing the response into a json for further use.
        client.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Paths.get("iSearch.json")));

        // Wanted to use this but the project requirements didn't align well with it. So I left it for later upgrades
//        HttpResponse<String> responseString = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(responseString.body());
    }

    /**
     * This is the JSON parsing method which uses the data stored in the JSON file on system and converts it into Java objects of Result class by using GSON utility of google.
     * @return APIResponse apiResponse
     */
    public static APIResponse getResultFromJson() {
        // Gson utility provided by google to convert JSON to Java Objects
        Gson gson = new Gson();
        APIResponse apiResponse = null;
        try (
                // Reading the json file in which the requested API call data is stored in json format
                FileReader fileReader = new FileReader("iSearch.json");

                // Json reader to interpret the data stored in json format
                JsonReader jsonReader = new JsonReader(fileReader);
        ) {
//            Storing the API call response(json data) into APIResponse class object, by converting it using Gson utility, to manipulate the data
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        } catch (Exception e) {
            // This is disabled for testing purpose
//            e.printStackTrace();
        }
        return apiResponse;
    }
}
