package cs126.demos.jsonapi.starwars;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


/**
 * Creates Film and Person objects based on a URL or integer index.
 * Objects are cached. i.e. The same Java object will be returned for the
 * same URL / index.
 *
 * Created by angrave on 2/6/17.
 */
public class StarWarsSource {

    public static final Charset UTF8 = Charset.forName("UTF-8");

    public static final String API_BASE_URL = "http://swapi.co/";
    public static final String API_FILMS_URL = API_BASE_URL + "api/films/";
    public static final String API_PEOPLE_URL = API_BASE_URL + "api/people/";


    public static final String USER_AGENT = "UIUC CS says thank you for your Starwars api";

    private Gson gson = new Gson();
    private Map<String, StarWarsEntity> cache = new HashMap<>();


    JsonReader getJson(String url) /*throws ApplicationException */ {
        String urlWithJson = url + "?format=json";
        try {
            long startTime = System.currentTimeMillis();

            URLConnection connection = new URL(urlWithJson).openConnection();
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.connect();

            InputStream inStream = connection.getInputStream();

            InputStreamReader reader = new InputStreamReader(inStream, UTF8);
            JsonReader jsonReader = new JsonReader(reader);

            long endTime = System.currentTimeMillis();
            System.out.println("Time required (ms): " + (endTime - startTime) + " to get " + url);

            return jsonReader;

        } catch (IOException ex) {
            System.out.println("Failed to get " + url + " : " + ex.getMessage());
            throw new ApplicationException(ex.getMessage());
        }
    }

    /**
     * Returns a Film object for the given film URL
     */
    public Film getFilm(String url) {

        Film film = (Film) cache.get(url);
        if (film == null) {
            System.out.println("No cache for film " + url);

            JsonReader json = getJson(url);

            film = gson.fromJson(json, Film.class);
            film.setSource(this);

            cache.put(url, film);
        } else {
            System.out.println("Reusing cache for film " + url);
        }


        return film;
    }

    /**
     * Returns a Person object for the given person URL
     */
    public Person getPerson(String url) {

        Person person = (Person) cache.get(url);

        if (person == null) {
            System.out.println("No cached version of Person " + url);

            JsonReader json = getJson(url);

            person = gson.fromJson(json, Person.class);
            person.setSource(this);

            cache.put(url, person);
        }
        return person;
    }

    /**
     * Returns a Film object for the given film index
     */
    public Film getFilm(int index) {
        return getFilm(API_FILMS_URL + index + "/");
    }

    /**
     * Returns a Person object for the given person index
     */
    public Person getPerson(int index) {

        return getPerson(API_PEOPLE_URL + index + "/");
    }
}
