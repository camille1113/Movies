import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by zhanglanxin on 2/7/17.
 */
public class movieAppTest{
    public static void main(String[] args){

    }

    @Test
    public void allMovieTitlesTest() throws Exception {
        assertEquals("The Secret Life of Pets" + "\n" + "Suicide Squad" + "\n" +
                "Finding Dory" + "\n" + "Jurassic World" + "\n" + "Arrival" + "\n",
                movieApp.getTitles("allMovieTitles",0,5,0,0.0));
    }

    @Test
    public void genreTest() throws Exception {
        assertEquals(" The Secret Life of Pets" + "\n" + "Jurassic World" + "\n" +
                "xXx: Return of Xander Cage" + "\n" + "Interstellar" + "\n" + "Mad Max: Fury Road" + "\n" +
                        "Fantastic Beasts and Where to Find Them"  + "\n" + "Assassin's Creed"  +"\n" + "Passengers"
                        + "\n" + "\n",
                movieApp.getTitles("genre",2,0,12,0));
    }

    @Test
    public void voteAverageTest() throws Exception {
        assertEquals(" Interstellar" + "\n" + "La La Land" + "\n" + "\n",
                movieApp.getTitles("voteAverage",2,0,0,7.8));

    }

    @Test
    public void popularityTest() throws Exception {
        assertEquals(" The Secret Life of Pets" + "\n",
                movieApp.getTitles("popularity", 2, 0, 0, 120.0));
    }

}

