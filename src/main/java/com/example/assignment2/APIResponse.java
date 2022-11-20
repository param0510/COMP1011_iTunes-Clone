package com.example.assignment2;

import java.util.Arrays;

public class APIResponse {
    private int resultCount;
    private Result[] results;

    public int getResultCount() {
        return resultCount;
    }

    public Result[] getResults() {
        return results;
    }

    @Override
    public String toString() {
        String apiResponseString =
                "Api Response: \n"+
                "resultCount: " + resultCount + "\n" +
                "results: \n{ \n";
        for (Result result: results)
        {
               apiResponseString+= result + "\n";
        }
        apiResponseString += "}";
        return apiResponseString;
    }
}
