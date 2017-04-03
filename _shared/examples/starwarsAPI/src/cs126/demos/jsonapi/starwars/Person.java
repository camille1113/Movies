package cs126.demos.jsonapi.starwars;

import java.util.Arrays;

/**
 * Java representation of a StarWars Movie Character.
 * Created by angrave on 2/6/17.
 */
public class Person extends StarWarsEntity {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String[] films;
    private String[] species;
    private String[] vehicles;
    private String[] starships;
    private String created;
    private String edited;
    private String url;

    /**
     * Constructs and returns an array of films that this character appeared in.
     */
    public Film[] getFilms() {
        Film[] filmReferences = new Film[films.length];

        for (int i = 0; i < films.length; i++) {
            filmReferences[i] = getSource().getFilm(films[i]);
        }
        return filmReferences;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Person{" +
                "\nname='" + name + '\'' +
                "\n, height='" + height + '\'' +
                "\n, mass='" + mass + '\'' +
                "\n, hair_color='" + hair_color + '\'' +
                "\n, skin_color='" + skin_color + '\'' +
                "\n, eye_color='" + eye_color + '\'' +
                "\n, birth_year='" + birth_year + '\'' +
                "\n, gender='" + gender + '\'' +
                "\n, homeworld='" + homeworld + '\'' +
                "\n, films=" + Arrays.toString(films) +
                "\n, species=" + Arrays.toString(species) +
                "\n, vehicles=" + Arrays.toString(vehicles) +
                "\n, starships=" + Arrays.toString(starships) +
                "\n, created='" + created + '\'' +
                "\n, edited='" + edited + '\'' +
                "\n, url='" + url + '\'' +
                '}';
    }
}
