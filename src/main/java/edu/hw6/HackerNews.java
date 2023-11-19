package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HackerNews {

    private static final String MOST_DISCUSSED_ARTICLES = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String GET_ID_STORIES = "https://hacker-news.firebaseio.com/v0/item/";
    private static final int OK_CODE = 200;

    private HackerNews() {
    }

    public static long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder().uri(new URI(MOST_DISCUSSED_ARTICLES)).GET().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == OK_CODE) {
                String json = response.body();
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(json);
                List<Long> tmpList = new ArrayList<>();
                while (matcher.find()) {
                    tmpList.add(Long.parseLong(matcher.group()));
                }

                long[] topStories = new long[tmpList.size()];
                for (int i = 0; i < tmpList.size(); i++) {
                    topStories[i] = tmpList.get(i);
                }
                return topStories;
            } else {
                return new long[] {};
            }

        } catch (URISyntaxException | IOException | InterruptedException e) {
            return null;
        }
    }

    public static String news(long id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder().uri(new URI(GET_ID_STORIES + id + ".json")).GET().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == OK_CODE) {
                Pattern pattern = Pattern.compile("\"title\":\"[^,]*");
                Matcher matcher = pattern.matcher(response.body());

                if (matcher.find()) {
                    return matcher.group(0).split(":")[1].replaceAll("\"", "");
                } else {
                    return null;
                }
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            return null;
        }
        return null;
    }

}
