import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GraphExperiment {
    public static void main(String[] args) {
        graphgen generator = new graphgen(10, 10, 20);
        try {
            generator.generateData("data2.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        {
            Graph g = new Graph( );
            try
            {   	
                FileReader fin = new FileReader("data2.txt");
                Scanner graphFile = new Scanner( fin );
    
                // Read the edges and insert
                String line;
                while( graphFile.hasNextLine( ) )
                {
                    line = graphFile.nextLine( );
                    StringTokenizer st = new StringTokenizer( line );
    
                    try
                    {
                        if( st.countTokens( ) != 3 )
                        {
                            System.err.println( "Skipping ill-formatted line " + line );
                            continue;
                        }
                        String source  = st.nextToken( );
                        String dest    = st.nextToken( );
                        int    cost    = Integer.parseInt( st.nextToken( ) );
                        g.addEdge( source, dest, cost );
                    }
                    catch( NumberFormatException e )
                      { System.err.println( "Skipping ill-formatted line " + line ); }
                 }
             }
             catch( IOException e )
               { System.err.println( e ); }
    
             System.out.println( "File read..." );
             System.out.println( g.vertexMap.size( ) + " vertices" );
    
            // Scanner in = new Scanner( System.in );
             
        }
    }
}
