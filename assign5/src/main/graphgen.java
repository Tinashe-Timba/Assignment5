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

    // initializes the number of vertices, edges, and weight limits
    public graphgen(int Vertices, int weightlim, int Edges) {
        this.Vertices = Vertices;
        this.weightlim = weightlim;
        this.Edges = Edges;
        this.random = new Random();
    }

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

    // Generates a list of node names in the format "NodeXXX", where XXX is a number from 1 to Vertices.
    private List<String> generateNodes() {
        List<String> nodes = new ArrayList<>();
        for (int i = 1; i <= Vertices; i++) {
            String node = "Node" + i;
            nodes.add(node);
        }
        return nodes;
    }

    // Returns a random element from the given list.
    private String getRandomElement(List<String> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public void Data(int V, int E, int vCount, int eCount,int pq_count) {
        String dataset = V + " " + E + " " + vCount + " " + eCount+" "+pq_count;
        String line = dataset + "\n";
        try {
            FileWriter writer = new FileWriter("Data.txt", true); // append to file
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }
    }

}
