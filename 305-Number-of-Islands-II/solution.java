public class Solution {
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind2D islands = new UnionFind2D(m, n);
        List<Integer> result = new ArrayList<>();
        int count = 0;
        
        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];
            // mark the new island in 1-D array and return index of it.
            int p = islands.addNewIsland(i, j);
            count++;

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                int q = x * n + y;

                if (x < 0 || y < 0 || x >= m || y >= n || islands.parent[q] == -1) {
                    continue;
                }
                // if adjacent is an island and belongs to two sets, union them.
                if (islands.find(p) != islands.find(q)) {
                    islands.union(p, q);
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    class UnionFind2D {
        int[] parent;
        int[] ranks;
        int m, n;

        public UnionFind2D(int m, int n) {
            parent = new int[m * n];
            ranks = new int[m * n];
            Arrays.fill(parent, -1);
            Arrays.fill(ranks, 0);

            this.m = m;
            this.n = n;
        }

        public int find(int id) {
            // path compression, set father of current id to root of the set.
            int father = parent[id];
            while (father != parent[father]) {
                father = parent[father];
            }
            
            while (id != parent[id]) {
                int temp = parent[id];
                parent[id] = father;
                id = temp;
            }
            return father;
        }

        public void union(int i, int j) {
            int iParent = find(i);
            int jParent = find(j);

            // Union by rank to minimize tree height and boost future find speed.
            int iRank = ranks[iParent];
            int jRank = ranks[jParent];

            if (iRank < jRank) {
                parent[iParent] = jParent;
            } else if (iRank > jRank) {
                parent[jParent] = iParent;
            } else {
                parent[iParent] = jParent;
                ranks[jParent]++;
            }
        }

        public int addNewIsland(int i, int j) {
            int index = i * n + j;
            parent[index] = index;
            ranks[index] = 1;
            return index;
        }
    }
}