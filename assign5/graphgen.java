
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class graphgen {
    private int Vertices;
    private int weightlim;
    private int Edges;
    private Random random;

    //intializes the number of vertices,edges and weight limits
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
        List<String> edges = new ArrayList<String>();
        while (edges.size() < numRows) {
            String node1 = getRandomElement(nodes);// picks a random node
            String node2 = getRandomElement(nodes);
            while (node2.equals(node1)) {   // checks to see if node 1 is not equal to node 2 
                node2 = getRandomElement(nodes);
            }
            int weight = random.nextInt(weightlim) + 1; // creates a weight for the edge
            String edge = node1 + " " + node2 + " " + weight;
            if (!edges.contains(edge)) { // checks if edge is already in the list of edges
                edges.add(edge);
                String line = edge + "\n";
                writer.write(line);
            }
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
}
