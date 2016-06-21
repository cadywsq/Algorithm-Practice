public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // map index: prerequisite course; map value: list of courses follows
        List<List<Integer>> map = new ArrayList<>();
        // indegree: count of prerequisites for each course
        int[] indegree = new int[numCourses];
        initializeGraph(indegree, map, prerequisites);
        return bfs(indegree, map);
    }
    
    private void initializeGraph(int[] indegree, List<List<Integer>> map, int[][] prerequisites) {
        for (int i = 0; i < indegree.length; i++) {
            map.add(new ArrayList<>());
        }
        
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            map.get(edge[1]).add(edge[0]);
        }
    }
    
    private int[] bfs(int[] indegree, List<List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        int[] order = new int[indegree.length];
        // add those that indegree is zero to the queue.
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // to track count of courses sorted
        int visited = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            order[visited++] = pre;
            // add next level of course with zero indegree to the queue.
            for (int course : map.get(pre)) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        return visited == indegree.length ? order : new int[0];
    }
}