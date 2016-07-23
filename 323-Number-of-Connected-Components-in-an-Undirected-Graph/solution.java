public class Solution {
public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        return unionFindSolution(n, edges);
        // return bfsSolution(n, edges);
        // return dfsSolution(n, edges);
    }

    //for each node parent[node] = node

    // for each node u :
    //   for each node v connected to u :
    //       if findset(u)!=findset(v) :
    //           union(u,v)

    // for each node if (parent[node] == node)
    //     connected_component += 1
    private int unionFindSolution(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = n;
        for (int i = 0; i < edges.length; i++) {
            int u = find(parent, edges[i][0]);
            int v = find(parent, edges[i][1]);
            if (u != v) {
                parent[u] = v;
                count--;
            }
        }
        return count;
    }

    private int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    private int bfsSolution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Adjacency List: as it's undirected graph, edges need to be added two-directional.
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    for (int neighbor : graph.get(j)) {
                        if (!visited[neighbor]) {
                            queue.offer(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }

            }
        }
        return count;
    }

    private int dfsSolution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // Adjacency List: as it's undirected graph, edges need to be added two-directional.
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, graph);
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int index, List<List<Integer>> graph) {
        visited[index] = true;
        for (int i : graph.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, graph);
            }
        }
    }
}