public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // draw a course graph represented by adjacency lists.
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int[] pair : prerequisites) {
            if (!courseMap.containsKey(pair[0])){
                courseMap.put(pair[0], new ArrayList<>());
            }
            courseMap.get(pair[0]).add(pair[1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] canFinishes = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinish(i, courseMap, visited, canFinishes)) {
                return false;
            }
        }
        return true;
    }
    
    // To decide whether there is cycle within course graph, dfs visit all prerequisites of the prerequisites of the course, if the course appears again in any of the prerequisites, a cycle exists.
    private boolean canFinish(int course, Map<Integer, List<Integer>> courseMap, boolean[] visited, boolean[] canFinishes) {
        if (visited[course]) {
            return false;
        }
        if (canFinishes[course]) {
            return true;
        }
        visited[course] = true;
        if (courseMap.containsKey(course)) {
            for (int pre : courseMap.get(course)) {
                if (!canFinish(pre, courseMap, visited, canFinishes)) {
                    return false;
                }
            }
        }
        canFinishes[course] = true;
        visited[course] = false;
        return true;
    }
}