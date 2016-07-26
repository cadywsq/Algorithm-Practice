public class Solution {
    public boolean isMatch(String s, String p) {
        // return isMatch1(s,p);
        return isMatch2(s,p);
    }
    
    /**Solution1: Recursion
     * check the current character of p
     * (1) null (2) ? (3) * (4) letter
    */
    public boolean isMatch1(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        if (p.charAt(0) == '?') {
            return s.length() != 0 && isMatch1(s.substring(1), p.substring(1));
        }
        
        if (p.charAt(0) == '*') {
            //We can ignore ‘*’ character and move to next character in the Pattern.
            boolean match0 = isMatch1(s, p.substring(1));
            //‘*’ character matches with one or more characters in Text. Here we will move to next character in the string.
            boolean match1 = s.length() != 0 && isMatch1(s.substring(1), p);
            return match0 || match1;
        }
        
        return s.length() != 0 && s.charAt(0) == p.charAt(0) && isMatch1(s.substring(1),p.substring(1));
    }
    
    /**Solution2: DP*/
    public boolean isMatch2(String s, String p) {
        // match[i][j]=true represents s(0,i) matches with p(0,j).
        boolean[][] match = new boolean[s.length()+1][p.length()+1];

        //Init: both text and pattern are null: match[0][0]=true
        //Init: pattern is null: match[i][0]=false, for all i>=1.
        //Init: text is null: match[0][j]=true if f[0][j-1] && p[j-1]='*', for all j>=1.
        match[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*') {
                match[0][i] = match[0][i-1];
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    match[i][j] = match[i-1][j] || match[i][j-1];
                } else if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
                    match[i][j] = match[i-1][j-1];
                } else {
                    match[i][j] = false;
                }
            }
        }
        return match[s.length()][p.length()];
    }
}