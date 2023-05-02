/**
 * The graphgen class 
 * Create a text file to measure the number of vertex-processing and edge-processing operations for different values of V and E. 
 * Use at values provided by the Graph Experiment class.  Then, for each value of V, a differnet  values of E. 
 *  For vertex names,  the convention of using use "NodeXXX" where the XXX is an integer is used.  
 * When generating edges randomly, Edges are not  are not repeated and and edges where  where the source and destination are the same are not generated.
 * For each pair of values of V and E, the program will then generate a dataset and measure performance.
 */
package main;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class graphgen {
    private int Vertices;
    private int weightlim;
    private int Edges;
    private Random random;
    /**
 * Initializes the number of vertices, edges, and weight limits.
 * @param Vertices The number of vertices.
 * @param weightlim The weight limit for the edges.
 * @param Edges The number of edges.
 */

    // initializes the number of vertices, edges, and weight limits
    public graphgen(int Vertices, int weightlim, int Edges) {
        this.Vertices = Vertices;
        this.weightlim = weightlim;
        this.Edges = Edges;
        this.random = new Random();
    }
/**
 * 
 * @param filename
 * @throws IOException
 */
    public void generateData(String filename) throws IOException {
        List<String> nodes = generateNodes(); // a list of nodes
        int numRows = Edges;
        FileWriter writer = new FileWriter(filename);
        HashSet<String> edges = new HashSet<String>(); // 
        List<String> edgesf = new ArrayList<>();
        while (edges.size() < Edges) {
            String node1 = getRandomElement(nodes);
            String node2 = getRandomElement(nodes);
            if (node1.equals(node2)) {
                continue; // skip this edge and try again
            }
            String edge = node1 + " " + node2;
            if (edgesf.contains(edge) || edgesf.contains(node2 + " " + node1)|| edgesf.contains(node1 + " " + node2)) {
                //System.out.println("skipping repeat");
                continue; // skip this edge and try again
            }
            int weight = random.nextInt(weightlim) + 1;
            edgesf.add(edge);
            edge += " " + weight;
            edges.add(edge);
        }

        for (String edge : edges) { // iterate over the unique edges and write them to file
            String line = edge + "\n";
            writer.write(line);
        }
        writer.close();
    }
/**
 * Generates a list of node names in the format "NodeXXX", where XXX is a number from 1 to Vertices.
 * @return A list of node names.
 */
    // Generates a list of node names in the format "NodeXXX", where XXX is a number from 1 to Vertices.
    private List<String> generateNodes() {
        List<String> nodes = new ArrayList<>();
        for (int i = 1; i <= Vertices; i++) {
            String node = "Node" + i;
            nodes.add(node);
        }
        return nodes;
    }

    /**
 * Returns a random element from the given list.
 * @param list The list to select a random element from.
 * @return A random element from the given list.
 */
    // Returns a random element from the given list.
    private String getRandomElement(List<String> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
    /**
 * Generates a dataset and appends it to a file.
    * @param V The number of vertices.
    * @param E The number of edges
    * @param vCount the number of vertix operation
    * @param eCount the number of edge operation
    * @param pq_count the number of priority queue operation
    */

    public void Data(int V, int E, int vCount, int eCount,int pq_count,int Elogv,int operations) {
        String dataset = V + " " + E + " " + vCount + " " + eCount+" "+pq_count+" "+Elogv+" "+operations;
        String line = dataset + "\n";
        try {
            FileWriter writer = new FileWriter("Data5.txt", true); // append to file
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
    }

}
