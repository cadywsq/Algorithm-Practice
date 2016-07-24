public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // return unionFindSolution(n, edges);
        return dfsSolution(n, edges);
    }
    
    /**Solution1: Union-Find*/
    private boolean unionFindSolution(int n, int[][] edges) {
        // initialize n isolated sets
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        // perform union-find
        for (int[] edge : edges) {
            int parent1 = find(parents, edge[0]);
            int parent2 = find(parents, edge[1]);
            
            if (parent1 == parent2) {
                return false;
            }
            union(parents, parent1, parent2);
        }
        // a tree is an undirected graph in which any two vertices are connected by exactly one path.
        // for a valid tree with n nodes, there must be n-1 edges.
        return edges.length == n-1;
    }
    
    private void union(int[] parents, int i, int j) {
        parents[i] = j;
    }
    
    private int find(int[] parents, int i) {
        int father = parents[i];
        while (father != parents[father]) {
            father = parents[father];
        }
        while (i != parents[i]) {
            int temp = parents[i];
            parents[i] = father;
            i = temp;
        }
        return father;
    }
    
    
    /**Solution2: DFS*/
    private boolean dfsSolution(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        // initialize vertices
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        // add edges
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);  
            adjList.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        // make sure there is no cycle
        if (hasCycle(adjList, 0, -1, visited)) {
            return false;
        }
        
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    
    private boolean hasCycle(List<List<Integer>> adjList, int u, int parent, boolean[] visited) {
        visited[u] = true;
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);
            // For every visited vertex ‘u’, if there is an adjacent ‘v’ such that v is already visited and v is not parent of u, then there is a cycle in graph. 
            if ((visited[v] && v != parent) || (!visited[v] && hasCycle(adjList, v, u, visited))) {
                return true;
            }
        }
        return false;
    }
}