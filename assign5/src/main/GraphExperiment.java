package main;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GraphExperiment {
    
    
        
        
    public static void main(String[] args) throws IOException  {

        int EV[][]=  {{10,20},{10,28},{10,30},{10,35},{10,40},{10,45},
                     {20,100},{20,120},{20,140},{20,160},{20,175},{20,190},
                    {30,200},{30,250},{30,300},{30,350},{30,400},{30,435},
                     {40,300},{40,400},{40,500},{40,600},{40,700},{40,780},
                     {50,500},{50,650},{50,750},{50,950},{50,1100},{50,1225},
                     {60,600},{60,750},{60,850},{60,1200},{60,1500},{60,1770},
                     {70,700},{70,1000},{70,1500},{70,2000},{70,2200},{70,2415},
                    };
        
        for (int i = 0; i < EV.length; i++){

        graphgen generator = new graphgen(EV[i][0], 20, EV[i][1]);
        String source1=null;// a varaible to hold the soruce of the data
        try {
            generator.generateData("datasets/data_"+EV[i][0]+"_"+EV[i][1]+".txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        {
            Graph g = new Graph( );
            try
            {   	
                FileReader fin = new FileReader("datasets/data_"+EV[i][0]+"_"+EV[i][1]+".txt");
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
                        source1=source;
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

             g.dijkstra(source1);
             
            System.out.println("number of pq ops"+ g.pq_count);
            System.out.println("Number of edges "+g.V);
            System.out.println("Number of edges "+g.E);
            System.out.println("Number of vertix operations "+g.vCount);
            System.out.println("Number of number of edge operation "+g.eCount);
            generator.Data( g.V,g.E, g.vCount, g.eCount,g.pq_count);
      
            
}
        }
             

    
            // Scanner in = new Scanner( System.in );
             
        }
    

    private static void println(String string) {
    }
}
