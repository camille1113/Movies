package cs126.demos.jsonapi.starwars;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests film and person cross references.
 */
public class FilmPersonLinkTest {

    private static final int MAX_FILM_INDEX = 7;
    private static final int MAX_PERSON_INDEX = 88;
    private static final int MISSING_PERSON_INDEX = 17;

    private StarWarsSource source;

    @Before
    public void setUp() throws Exception {
        source = new StarWarsSource();
    }

    /**
     * Tests that every person to film link has a corresponding link from the film back to the person.
     */
    @Test
    public void testLinkBackTest() {
        for (int personIndex = 1; personIndex <= MAX_PERSON_INDEX; personIndex++) {
            if (validPersonIndex(personIndex)) {

                Person person = source.getPerson(personIndex);
                Film[] films = person.getFilms();
                for (Film film : films) {
                    assertTrue(filmContainsPerson(film, person));
                }
            }
        }
    }

    @Test
    public void testPersonHasAtLeastOneMovie() {
        for (int personIndex = 1; personIndex <= MAX_PERSON_INDEX; personIndex++) {
            if (validPersonIndex(personIndex)) {
                Person person = source.getPerson(personIndex);
                assertTrue(person.getFilms().length > 0);
            }
        }
    }

    @Test
    public void testMovieHasAtLeastOnePerson() {
        for (int filmIndex = 1; filmIndex <= MAX_FILM_INDEX; filmIndex++) {
            Film film = source.getFilm(filmIndex);
            assertTrue(film.getPeople().length > 0);
        }

    }

    private static boolean filmContainsPerson(Film film, Person person) {
        Person[] appear = film.getPeople();
        for (Person appearsInFilm : appear) {
            if (appearsInFilm == person) {
                return true;
            }
        }
        return false;
    }

    private static boolean validPersonIndex(int index) {
        return index > 0
                && index < MAX_PERSON_INDEX
                && index != MISSING_PERSON_INDEX;
    }
}