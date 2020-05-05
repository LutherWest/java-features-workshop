package com.epam.features._9_lib_enhancements._2_standard_http_client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StandardHttpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        final var client = HttpClient.newBuilder().build();

        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://worldclockapi.com/api/json/utc/now"))
                .build();

        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
