package com.example.assignment2;

import java.util.Arrays;

public class APIResponse {
    private int resultCount;
    private Result[] results;

    /**
     * Getter for resultCount instance variable which gives us the total number of results generated
     * @return int resultCount
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     * Getter for the array of all the result objects generated
     * @return Result[] results
     */
    public Result[] getResults() {
        return results;
    }

    /**
     * ToString method for getting the data in String format for better data manipulation and testing
     * @return
     */
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
