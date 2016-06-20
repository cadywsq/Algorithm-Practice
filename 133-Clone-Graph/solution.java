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
        Map<Integer, UndirectedGraphNode> newNodes = new HashMap<>();
        return dfsClone(node, newNodes);
    }
    
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
}