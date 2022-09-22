import java.util.NoSuchElementException;


public class DSAGraph {
    private DSALinkedList vertices;
    private int vertexCount;
    private int edgeCount;

    public DSAGraph()
    {
        vertices = new DSALinkedList();
        vertexCount = 0;
        edgeCount = 0;
    }

    public void addVertex(String value){
        if(value.equals(""))
        {
            throw new IllegalArgumentException("Empty string cannot be used as a vertices label");

        }else
        {
            if(!hasVertex(value))//Check if vertex is already being added
            {
                vertices.insertLast(new DSAGraphVertex(value));
                vertexCount++;

            }else
            {
                throw new IllegalArgumentException("Vertex already exists");
            }

        }

    }

    public void addEdge(String label1,String label2)
    {
        DSAGraphVertex vertex1 = null;
        DSAGraphVertex vertex2 = null;
        //These if statment is for cases where added edge don't have vertices added yet
        if(!hasVertex(label1))
        {
            addVertex(label1);
        }

        if(!hasVertex(label2))
        {
            addVertex(label2);
        }

        vertex1 = getVertex(label1);
        vertex2 = getVertex(label2);

        if(isAdjacent(vertex1, vertex2))
        {
            throw new IllegalArgumentException(label1+" " + label2 + " Already has a connection");
        }else
        {
            vertex1.addEdge(vertex2);
            vertex2.addEdge(vertex1);
        }

        edgeCount++;
    }



    public boolean hasVertex(String label)
    {
        boolean found = false;
        for(Object o: vertices)
        {
            if(((DSAGraphVertex)o).getLabel().equals(label))
            {
                found = true;
            }

        }
        return found;
    }

    public int getVertexCount()
    {
        return vertexCount;
    }

    public int getEdgeCount()
    {
        return edgeCount;
    }

    public DSAGraphVertex getVertex(String label)
    {
        DSAGraphVertex vertex = null;
        if(!hasVertex(label))
        {
            throw new NoSuchElementException(label + " Does not exist in Graph");

        }else
        {
            for(Object o: vertices)
            {
                if(((DSAGraphVertex)o).getLabel().equals(label))
                {
                    vertex = (DSAGraphVertex)o;
                }
            }
        }
        return vertex;
    }

    public DSALinkedList getEdge(String label)
    {
        return null;
    }

    public DSALinkedList getAdjacent(String label)
    {
        return getVertex(label).getAdjacent();
    }

    public boolean isAdjacent(DSAGraphVertex vertex1,DSAGraphVertex vertex2)
    {
        boolean adjacent = false;
        for(Object o: vertex1.getAdjacent())
        {
            if(((DSAGraphVertex)o).equals(vertex2))
            {
                adjacent = true;
            }
        }
        
        return adjacent;
    }
    
    public void displayAsList(){
        
        for(Object v: vertices)
        {
            System.out.print(" " + ((DSAGraphVertex)v).getLabel());
            for(Object o: ((DSAGraphVertex)v).getAdjacent())
            {
                System.out.print(" " + ((DSAGraphVertex)o).getLabel());
            }
            System.out.println();
        }

        
    }
    public void displayAsMatrix(){
        int idx = 0;
        String[][] vertexMatrix = new String[vertexCount+1][vertexCount+1];
        DSAGraphVertex[] vertexArr = new DSAGraphVertex[vertexCount];
    
        for(Object o:vertices)
        {
            vertexArr[idx] = (DSAGraphVertex)o;
            idx++;
        }

        vertexMatrix[0][0] = " ";
        for( int i = 0; i < vertexCount+1; i++ )
        {
            for( int j = 0; j < vertexCount+1; j++ )
            {
                if(i == 0 || j == 0)//To create the labels row and columns
                {
                    
                    if(i==0)
                    {
                        if(j > 0)
                        {
                            vertexMatrix[i][j]= vertexArr[j-1].getLabel();

                        }
                        
                    }else
                    {
                        if(i > 0)
                        {
                            vertexMatrix[i][j]= vertexArr[i-1].getLabel();

                        }
                        
                    }
                }else
                {
                    if( isAdjacent( vertexArr[i-1], vertexArr[j-1] ) )
                    {
                        vertexMatrix[i][j] = "1";
                    }
                    else
                    {
                        vertexMatrix[i][j] = "0";
                    }
                }

            }
        }
        

        for(int i=0;i<vertexCount+1;i++)
        {
            for(int j=0;j<vertexCount+1;j++)
            {
                System.out.print(vertexMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void depthFirstSearch()
    {
        //Makes sure the vertices are all set to unvisted before starting visited
        for(Object o: vertices)
        {
            ((DSAGraphVertex)o).clearVisted();
        }

        depthFirstSearchRec( (DSAGraphVertex)(vertices.peekFirst()));
        System.out.println();
    }

    private void depthFirstSearchRec(DSAGraphVertex vertex)
    {
        DSAGraphVertex visiting;
        vertex.setVisted();
        
        for(Object o: vertex.getAdjacent())
        {
            visiting = (DSAGraphVertex)o;
            
            if(!visiting.getVisited())
            {
                System.out.print("( " + vertex + " , " + visiting + " ) ");
                depthFirstSearchRec(visiting);
            }
        }
    }

    public void breadthFirstSearch()
    {
        DSAQueue queue = new DSAQueue();
        
        for(Object o: vertices)
        {
            ((DSAGraphVertex)o).clearVisted();
        }

        queue.enqueue(vertices.peekFirst());
        ( (DSAGraphVertex)(vertices.peekFirst()) ).setVisted();
        bfsRec(queue);
        System.out.println();
    }

    private void bfsRec(DSAQueue queue)
    {
        DSAGraphVertex vertex = (DSAGraphVertex)queue.dequeue();
        DSAGraphVertex visiting;
        for(Object o : vertex.getAdjacent())
        {
            visiting = (DSAGraphVertex)o;
            if(!visiting.getVisited())
            {
                queue.enqueue(visiting);
                visiting.setVisted();
                System.out.print("( " + vertex + " , " + visiting + " ) ");
            }
        }

        if(!queue.isEmpty())
        {
            bfsRec(queue);
        }
    }


    private class DSAGraphVertex {
        public String label;
        public DSALinkedList links;
        private boolean visited;
        private int edgeCount;
        
        
        private DSAGraphVertex(String inLabel)
        {
            label = inLabel;
            links = new DSALinkedList();
            visited = false;
            edgeCount = 0;
        }

        public int getEdgeCount()
        {
            return edgeCount;
        }

        public String getLabel()
        {
            return label;
        }

        public DSALinkedList getAdjacent()
        {
            return links;
        }
 

        public boolean getVisited()
        {
            return visited;
        }

        public boolean equals(DSAGraphVertex vertex)
        {
            return (label.equals(vertex.getLabel()));
        }

        public void addEdge(DSAGraphVertex inVertex)
        {
            if(inVertex != null)
            {
                links.insertLast(inVertex);
                edgeCount++;
            }else
            {
                throw new IllegalArgumentException("Null Vertex cannot be added");
            }

        }

        public void setVisted()
        {
            visited = true;
        }

        public void clearVisted()
        {
            visited = false;
        }

        public String toString()
        {
            return label;
        }
        
    }
    
}
