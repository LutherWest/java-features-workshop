package com.epam.features._9_lib_enhancements._2_standard_http_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StandardHttpClient {
    public static void main(String[] args) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("http://worldclockapi.com/api/json/utc/now")
                .openConnection();
        //add headers to the connection, or check the status if desired..

        // handle error response code it occurs
        int responseCode = connection.getResponseCode();
        InputStream inputStream;
        if (200 <= responseCode && responseCode <= 299) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {
            String currentLine;

            while ((currentLine = in.readLine()) != null)
                response.append(currentLine).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response.toString());
    }
}
