package fr.ogu.INITEST;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class makeRequest {
    public static void main(String args) {
        checkUrl(args);
    }

    private static String URL = "https://emailvalidation.abstractapi.com/v1/?api_key=028ad2af6f84427a8fd2c3e28d1a2256&email=";

    public static void checkUrl(String email) {
        HttpGet req = new HttpGet(URL + email);
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            CloseableHttpResponse execute = httpClient.execute(req);
            BufferedReader is = new BufferedReader(new InputStreamReader(execute.getEntity().getContent()));
            System.out.println(is.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
