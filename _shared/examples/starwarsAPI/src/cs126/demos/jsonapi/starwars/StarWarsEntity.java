package cs126.demos.jsonapi.starwars;

/**
 * Base class for StarWars entities such as a Film and Person object.
 * Object collections are lazily loaded so each object needs
 * a reference back to the Source.
 * Created by angrave on 2/6/17.
 */
public class StarWarsEntity {

    private StarWarsSource source;

    public StarWarsSource getSource() {
        return source;
    }

    public void setSource(StarWarsSource source) {
        this.source = source;
    }

}
