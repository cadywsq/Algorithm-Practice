public class Solution {
    public int calculate(String s) {
        s = s.trim().replaceAll(" +","");
        int result = 0;
        // int may overflow here.
        long preNum = 0;
        char sign = '+';
        int i = 0;
        while (i < s.length()) {
            long curNum = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                curNum = 10 * curNum + (s.charAt(i)-'0');
                i++;
            }  
            if (sign == '+') {
                result += preNum;
                preNum = curNum;
            } else if (sign == '-') {
                result += preNum;
                preNum = -curNum;
            } else if (sign == '*') {
                preNum *= curNum;
            } else if (sign == '/') {
                if (curNum == 0) {
                    throw new RuntimeException();
                }
                preNum /= curNum;
            }
            if (i < s.length()) {
                sign = s.charAt(i);
                i++;
            }
        }
        result += preNum;
        return result;
    }
}