/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String SPLITTER = ",";
    private static final String NULL = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encodeTree(root, sb);
        return sb.toString();
    }
    
    // as tree will need to be rebuilt top-down, we use preorder traversal to encode tree.
    private void encodeTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            // when call split(), the last element will be truncated if it's "".
            sb.append(NULL).append(SPLITTER);
            return;
        }
        sb.append(root.val).append(SPLITTER);
        encodeTree(root.left, sb);
        encodeTree(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLITTER)));
        return decodeTree(nodes);
    }
    
    private TreeNode decodeTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = decodeTree(nodes);
        root.right = decodeTree(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));