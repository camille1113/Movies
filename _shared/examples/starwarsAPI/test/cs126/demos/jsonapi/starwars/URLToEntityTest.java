package cs126.demos.jsonapi.starwars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by angrave on 2/6/17.
 * Simple tests to validate reading of one person and one film
 */
public class URLToEntityTest {

    public static final String EXAMPLE_FILM_URL = "http://swapi.co/api/films/1/";
    public static final String EXPECTED_FILM_CONTENTS = "Film{\n" +
            "title='A New Hope'\n" +
            ", directory='null'\n" +
            ", producer='Gary Kurtz, Rick McCallum'\n" +
            ", release_date='1977-05-25'\n" +
            ", characters=[http://swapi.co/api/people/1/, http://swapi.co/api/people/2/, http://swapi.co/api/people/3/, http://swapi.co/api/people/4/, http://swapi.co/api/people/5/, http://swapi.co/api/people/6/, http://swapi.co/api/people/7/, http://swapi.co/api/people/8/, http://swapi.co/api/people/9/, http://swapi.co/api/people/10/, http://swapi.co/api/people/12/, http://swapi.co/api/people/13/, http://swapi.co/api/people/14/, http://swapi.co/api/people/15/, http://swapi.co/api/people/16/, http://swapi.co/api/people/18/, http://swapi.co/api/people/19/, http://swapi.co/api/people/81/]\n" +
            ", planets=[http://swapi.co/api/planets/2/, http://swapi.co/api/planets/3/, http://swapi.co/api/planets/1/]\n" +
            ", starships=[http://swapi.co/api/starships/2/, http://swapi.co/api/starships/3/, http://swapi.co/api/starships/5/, http://swapi.co/api/starships/9/, http://swapi.co/api/starships/10/, http://swapi.co/api/starships/11/, http://swapi.co/api/starships/12/, http://swapi.co/api/starships/13/]\n" +
            ", vehicles=[http://swapi.co/api/vehicles/4/, http://swapi.co/api/vehicles/6/, http://swapi.co/api/vehicles/7/, http://swapi.co/api/vehicles/8/]\n" +
            ", species=[http://swapi.co/api/species/5/, http://swapi.co/api/species/3/, http://swapi.co/api/species/2/, http://swapi.co/api/species/1/, http://swapi.co/api/species/4/]\n" +
            ", created='2014-12-10T14:23:31.880000Z'\n" +
            ", edited='2015-04-11T09:46:52.774897Z'\n" +
            ", url='http://swapi.co/api/films/1/'}";
    public static final String EXAMPLE_PERSON_URL = "http://swapi.co/api/people/1/";
    public static final String EXPECTED_PERSON_CONTENTS = "Person{\n" +
            "name='Luke Skywalker'\n" +
            ", height='172'\n" +
            ", mass='77'\n" +
            ", hair_color='blond'\n" +
            ", skin_color='fair'\n" +
            ", eye_color='blue'\n" +
            ", birth_year='19BBY'\n" +
            ", gender='male'\n" +
            ", homeworld='http://swapi.co/api/planets/1/'\n" +
            ", films=[http://swapi.co/api/films/6/, http://swapi.co/api/films/3/, http://swapi.co/api/films/2/, http://swapi.co/api/films/1/, http://swapi.co/api/films/7/]\n" +
            ", species=[http://swapi.co/api/species/1/]\n" +
            ", vehicles=[http://swapi.co/api/vehicles/14/, http://swapi.co/api/vehicles/30/]\n" +
            ", starships=[http://swapi.co/api/starships/12/, http://swapi.co/api/starships/22/]\n" +
            ", created='2014-12-09T13:50:51.644000Z'\n" +
            ", edited='2014-12-20T21:17:56.891000Z'\n" +
            ", url='http://swapi.co/api/people/1/'}";

    StarWarsSource source;

    @Before
    public void setup() {
        source = new StarWarsSource();
    }

    @Test
    public void filmTest() {
        StarWarsSource source = new StarWarsSource();
        Film film = source.getFilm(EXAMPLE_FILM_URL);
        System.out.println(film.toString());
        assertEquals(EXPECTED_FILM_CONTENTS, film.toString());
    }

    @Test
    public void personTest() {

        Person person = source.getPerson(EXAMPLE_PERSON_URL);
        System.out.println(person.toString());
        assertEquals(EXPECTED_PERSON_CONTENTS, person.toString());
    }

    @Test
    public void cacheObjectTest() {

        Person person = source.getPerson(1);
        assertTrue (person == source.getPerson(1));

        Film film = source.getFilm(1);
        assertTrue (film == source.getFilm(1));
    }

}