public class Solution {
    public int calculate(String s) {
        int number = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c-'0');
            } else if (c == '+') {
                //Add num to result before this sign; This sign = Last context sign * 1; clear num;
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                //Add num to result before this sign; This sign = Last context sign * -1; clear num;
                result += number * sign;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += number * sign;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        //Add the last num. This is because we only add number after '+' / '-'.
        result += number * sign;
        
        return result;
    }
}