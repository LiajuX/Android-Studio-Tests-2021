package com.example.starwarsmovies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class NetworkToolkit {
    public static String doGet(String url) {
        String result = "";

        try {
            URL apiEnd = new URL(url);

            int statusCode;
            HttpURLConnection connection;
            InputStream is;

            connection = (HttpURLConnection) apiEnd.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(15000);
            connection.connect();

            statusCode = connection.getResponseCode();

            if (statusCode < HttpURLConnection.HTTP_BAD_REQUEST) {
                is = connection.getInputStream();

            } else {
                is = connection.getErrorStream();
            }

            result = converterInputStreamToString(is);
            is.close();
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (ProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static String converterInputStreamToString(InputStream is) {
        StringBuffer buffer = new StringBuffer();

        try {
            BufferedReader br;
            String line;

            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  buffer.toString();
    }
}
