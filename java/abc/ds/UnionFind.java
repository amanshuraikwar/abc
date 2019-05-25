package abc.ds;

import java.util.List;
import java.util.ArrayList;

public interface UnionFind {

    int find(int val);
    boolean union(int val1, int val2);

    class SimpleUnionFind implements UnionFind {

        private List<Integer> parents;

        public SimpleUnionFind(int noOfEdges) {
            parents = new ArrayList<>(noOfEdges);
            // initialising the sets
            for(int i = 0; i < noOfEdges; i++) {
                parents.add(-1);
            }
        }

        @Override
        public int find(int val) {
            
            if (val >= parents.size() || val < 0) {
                return -1;
            }

            if (parents.get(val) == -1) {
                return val;
            } 

            return find(parents.get(val));
        }

        @Override
        public boolean union(int val1, int val2) {
            
            if (val1 >= parents.size() || val1 < 0 || val2 >= parents.size() || val2 < 0) {
                return false;
            }

            if (parents.get(val1) != -1 || parents.get(val2) != -1) {
                return false;
            }

            parents.set(val2, val1);
            return true;
        }
    }
}