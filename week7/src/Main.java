import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by zhanglanxin on 2/20/17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(GraphMap.map);

        TextIO.putln("Please choose grid or graph");
        String s = TextIO.getln();
        if (s.equals("grid"))
            System.out.println("Shortest way: " + "\n" + AStar.get_path(getGrid()));
        else if (s.equals("graph"))
            System.out.println("Shortest way: " + "\n" + AStar.get_path(graph));
        else
            System.out.println("Invalid input");

    }

    public static Grid getGrid() throws IOException {
        URL url = new URL("https://courses.engr.illinois.edu/cs126/resources/grid.json");
        InputStream inStream = url.openStream();
        InputStreamReader reader = new InputStreamReader(inStream, Charset.forName("UTF-8"));
        JsonReader jsonReader = new JsonReader(reader);
        Gson gson = new Gson();
        Grid grid = gson.fromJson(jsonReader, Grid.class);
        return grid;
    }
//    public static Grid getGraph() throws IOException {
//        URL url = new URL("https://subversion.ews.illinois.edu/svn/sp17-cs126/_shared/json/graph.json");
//        InputStream inStream = url.openStream();
//        InputStreamReader reader = new InputStreamReader(inStream, Charset.forName("UTF-8"));
//        JsonReader jsonReader = new JsonReader(reader);
//        Gson gson = new Gson();
//        Grid graph = gson.fromJson(jsonReader, Graph.class);
//        return graph;
//    }

}
