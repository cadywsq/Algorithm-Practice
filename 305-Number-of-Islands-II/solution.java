public class Solution {
    private final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[] islands = new int[m*n]; // one island equals one tree
        Arrays.fill(islands, -1);
        int count = 0; // count of islands
        
        for (int[] p : positions) {
            int i = p[0] * n + p[1];
            islands[i] = i; // mark the island as parent of itself
            count++;
            
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int j = x * n + y; // index of neighbor
                if (x < 0 || y < 0 || x >= m || y >= n || islands[j] == -1) {
                    continue;
                }
                // if neighbor is another island, union the two islands.
                int iParent = find(islands, i);
                int jParent = find(islands, j);
                if (iParent != jParent) {
                    islands[iParent] = jParent;
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }
    
    private int find(int[] parents, int i) {
        int father = parents[i];
        // find the ultimate root of i.
        while (father != parents[father]) {
            father = parents[father];
        }
        // set root of all set element to the ultimate root to flatten the tree.
        while (i != parents[i]) {
            int temp = parents[i];
            parents[i] = father;
            i = temp;
        }
        return father;
    }
}