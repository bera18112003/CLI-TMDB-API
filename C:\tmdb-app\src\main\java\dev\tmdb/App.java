package dev.tmdb;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.io.IOException;
import java.util.concurrent.Callable;

public class App implements Callable<Integer> {

    @Option(names = {"--type"}, description = "Type of movies: playing, popular, top, upcoming", required = true)
    private String type;

    private final String API_KEY = "";
    private final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    private OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        String endpoint = switch (type.toLowerCase()) {
            case "playing" -> "now_playing";
            case "popular" -> "popular";
            case "top" -> "top_rated";
            case "upcoming" -> "upcoming";
            default -> null;
        };

        if (endpoint == null) {
            System.out.println("Invalid type! Use: playing, popular, top, upcoming");
            return 1;
        }

        fetchAndPrintMovies(endpoint);
        return 0;
    }

    private void fetchAndPrintMovies(String endpoint) {
        String url = BASE_URL + endpoint + "?api_key=" + API_KEY + "&language=en-US&page=1";

        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("API Error: " + response);
                return;
            }

            String json = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode results = root.get("results");

            System.out.println("=== " + type.toUpperCase() + " MOVIES ===");
            for (JsonNode movie : results) {
                String title = movie.get("title").asText();
                String releaseDate = movie.get("release_date").asText();
                double rating = movie.get("vote_average").asDouble();
                System.out.printf("%s (%s) - Rating: %.1f%n", title, releaseDate, rating);
            }

        } catch (IOException e) {
            System.out.println("Network/API Error: " + e.getMessage());
        }
    }
}
 
