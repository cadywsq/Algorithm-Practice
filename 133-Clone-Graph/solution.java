/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Map<Integer, UndirectedGraphNode> newNodes = new HashMap<>(); // store visited nodes
        return bfsClone(node, newNodes);
    }
    
    /**Solution1: dfs
     */
    private UndirectedGraphNode dfsClone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> newNodes) {
        if (node == null) {
            return null;
        }
        // equivalent to using a visited boolean to avoid duplicated visits.
        if (newNodes.containsKey(node.label)) {
            return newNodes.get(node.label);
        }
        // make copy for the current node
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        newNodes.put(copy.label, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            // dfs to add all neighbor copies to neighbor list.
            copy.neighbors.add(dfsClone(neighbor, newNodes));
        }
        return copy;
    }
    
    /**Solution2: bfs
     */
     private UndirectedGraphNode bfsClone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> newNodes) {
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); // new node for return
        newNodes.put(node.label, newNode);
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();// store original nodes to be visited
        queue.offer(node);
        
        while (!queue.isEmpty()) {
           UndirectedGraphNode n = queue.poll();

           for (UndirectedGraphNode neighbor : n.neighbors) {
               if (!newNodes.containsKey(neighbor.label)) {
                    newNodes.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
               }
               // add new created neighbor to node's neighbor list
               newNodes.get(n.label).neighbors.add(newNodes.get(neighbor.label)); 
           }
        }
        return newNode;
     }
}