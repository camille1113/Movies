package cs126.demos.jsonapi.starwars;

import java.util.Arrays;

/**
 * Java representation of a StarWars Film.
 * Created by angrave on 2/6/17.
 */
public class Film extends StarWarsEntity {
    private String title;
    private String directory;
    private String producer;
    private String release_date;
    private String[] characters;
    private String[] planets;
    private String[] starships;
    private String[] vehicles;
    private String[] species;
    private String created;
    private String edited;
    private String url;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    /**
     * Constructs and returns an array of characters that appeared in this movie.
     */
    public Person[] getPeople() {
        Person[] people = new Person[characters.length];

        for (int i = 0; i < characters.length; i++) {
            people[i] = getSource().getPerson(characters[i]);
        }

        return people;
    }

    @Override
    public String toString() {
        return "Film{" +
                "\ntitle='" + title + '\'' +
                "\n, directory='" + directory + '\'' +
                "\n, producer='" + producer + '\'' +
                "\n, release_date='" + release_date + '\'' +
                "\n, characters=" + Arrays.toString(characters) +
                "\n, planets=" + Arrays.toString(planets) +
                "\n, starships=" + Arrays.toString(starships) +
                "\n, vehicles=" + Arrays.toString(vehicles) +
                "\n, species=" + Arrays.toString(species) +
                "\n, created='" + created + '\'' +
                "\n, edited='" + edited + '\'' +
                "\n, url='" + url + '\'' +
                '}';
    }


}
