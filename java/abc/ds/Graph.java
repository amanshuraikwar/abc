package abc.ds;

import java.util.List;
import java.util.ArrayList;

public interface Graph {

    void insert(int v1, int v2);
    List<Integer> getAdjacentNodes(int v);

    class AdjacencyList implements Graph {

        private ArrayList<Integer>[] adjacencyList;

        public AdjacencyList(int noOfVertices) {
            
            adjacencyList = new ArrayList[noOfVertices]; 
            
            for (int i = 0; i < noOfVertices; i++) {
                adjacencyList[i] = new ArrayList<Integer>();
            }
        }

        @Override
        public void insert(int v1, int v2) {
            adjacencyList[v1].add(v2);
        }

        @Override
        public List<Integer> getAdjacentNodes(int v) {
            return adjacencyList[v];
        } 
    }

    class AdjacencyMatrix implements Graph {

        private int[][] adjacencyMatrix;

        public AdjacencyMatrix(int noOfVertices) {

            adjacencyMatrix = new int[noOfVertices][noOfVertices];

            for (int i = 0; i < noOfVertices; i++) {
                
                for (int j = 0; j < noOfVertices; j++) {
                    
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }

        @Override
        public void insert(int v1, int v2) {
            adjacencyMatrix[v1][v2] = 1;
        }

        @Override
        public List<Integer> getAdjacentNodes(int v) {

            List<Integer> nodes = new ArrayList<Integer>();

            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[v][i] == 1) {
                    nodes.add(i);
                }
            }

            return nodes;
        }
    }
}