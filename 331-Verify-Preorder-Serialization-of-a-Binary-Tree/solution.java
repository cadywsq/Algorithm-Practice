public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < nodes.length; i++) {
            stack.push(nodes[i]);
            int size = stack.size();
            while (isLeafNode(stack)) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            } 
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
    
    private boolean isLeafNode(Stack<String> stack) {
        int size = stack.size();
        return size >= 3 && stack.get(size-1).equals("#") && stack.get(size-2).equals("#") && !stack.get(size-3).equals("#");
    }
}