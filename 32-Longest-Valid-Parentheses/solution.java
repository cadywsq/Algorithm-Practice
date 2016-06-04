public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        return solution2(s);
    }
    
    /** DP solution with O(N) efficiency.
    * Function: 
    *  if s[i-1]=='(', f[i]=0.
    *      if s[i-1]==')', s[i-2] may be '(' or ')'.
    *          if s[i-2]='(', s[i-1] and s[i-2] is a matching pair.
    *          if s[i-2]=')', we know the longest valid substring ended with s[i-2] is f[i-1].
    *            If there is a matching with s[i-1], the position should be i-1-f[i-1]-1 = i-f[i-1]-2
    *            So if s[i-f[i-1]-2] is '(', is is a matching with s[i-1].
    *              Then f[i] = length of substring [s[i-f[i-1]-2],s[i-1]] + largest valid substring ended with s[i-f[i-1]-3] = f[i-1]+2 + s[i-f[i-1]-2]
    */
    private int solution1(String s) {
        //  State: f[i] denotes longest substring ended with s[i-1] that is valid.
        int[] validLen = new int[s.length()+1];
        
        int maxLen = 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '(') {
                continue;
            } 
            
            if (s.charAt(i-2) == '(') {
                validLen[i] = validLen[i-2]+2;
            } else {
                int index = i-1 - validLen[i-1] - 1;
                if (index >= 0 && s.charAt(index) == '(') {
                    validLen[i] = validLen[i-1]+2 + validLen[index];
                }
            }
            maxLen = Math.max(maxLen, validLen[i]);
        }
        return maxLen;
    }
    
    /** Solution 1: O(n) with stack
         * Traverse each character of input.
         * If current character is '(', push its index to the stack.
         * If current character is ')' and the character at the index of the peek of stack is '(',
         *   they are a matching pair so pop from the stack. Otherwise, we push the index of ')' to the stack.
         * After traversal, the stack will only contain the indices of characters which cannot be matched.
         * So substring between adjacent indices should be valid parentheses.
         * If the stack is empty, the whole input string is valid.
    */
    private int solution2(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    continue;
                } 
            } 
            stack.push(i);
        }
        
        if (stack.isEmpty()) {
            return s.length();
        }
        
        int maxLen = 0;
        int start = 0; int end = s.length();
        while (!stack.isEmpty()) {
            start = stack.pop();
            maxLen = Math.max(maxLen, end-start-1);
            end = start;
        }
        maxLen = Math.max(maxLen, end);
        
        return maxLen;
    }
}