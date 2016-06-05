public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    result = stack.pop() + stack.pop();
                    break;
                case "-":
                    result = -stack.pop() + stack.pop();
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    break;
                case "/":
                    // result = 1 / stack.pop() * stack.pop();
                    int denom = stack.pop();
                    int numer = stack.pop();
                    result = numer/denom;
                    break;
                default:
                    result = Integer.valueOf(tokens[i]);
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}