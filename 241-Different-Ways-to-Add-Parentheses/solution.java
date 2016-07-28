public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        
        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                // divide: for every operator, expression can be divided to left and right parts
                List<Integer> leftResult = diffWaysToCompute(input.substring(0,i));
                List<Integer> rightResult = diffWaysToCompute(input.substring(i+1));
                
                // conquer: get the total of left and right parts, meaning that there are parentheses on the left and right of current operator.
                for (Integer left : leftResult) {
                    for (Integer right : rightResult) {
                        int total = 0;
                        switch(c) {
                            case '+':
                                total = left + right;
                                break;
                            case '-':
                                total = left - right;
                                break;
                            case '*':
                                total = left * right;
                                break;
                            case '/':
                                if (right != 0) {
                                    total = left / right;
                                }
                                break;
                            default:
                                break;
                        }
                        result.add(total);
                    }
                }
            }
        }
        // don't miss it, base case!!!
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}