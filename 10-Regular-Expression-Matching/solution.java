public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch2(s, p);
    }
    
    /**Solution1: Recursion*/
    public boolean isMatch1(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //x* may match 0 char in s.
            boolean match0 = isMatch1(s, p.substring(2));
            //x* may match one or more chars in s. Their first chars should be same, OR first char of p is '.'
            boolean match1 = s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch1(s.substring(1), p);
            return match0 || match1;
        } 
        return s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch1(s.substring(1), p.substring(1));
    }
    
    /**Solution2: DP*/
    public boolean isMatch2(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        
        //Init: match[0][0]=true
        //Init: match[k][0]=false, for all k>=1.
        //Init: match[0][2k-1]=false, for all k>=1. 
        //Init: match[0][2k]=true iff f[0][2k-2] && p[2k-1]='*', for all k>=1.  
        //(if s==null, p==c*c*c*...can match)
        match[0][0] = true;
        for (int k = 1; k*2 <= p.length(); k++) {
            if (p.charAt(2*k-1) == '*') {
                match[0][2*k] = match[0][2*k-2];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    //in this case, a* only counts as empty
                    if (match[i][j - 2]) {
                        match[i][j] = true;
                    }
                    //in this case, a* counts as multiple a or a single a
                    if (match[i - 1][j] && 
                        (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        match[i][j] = true;
                    }
                } else {
                    match[i][j] = match[i-1][j-1] && 
                    (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
                }
            }
        }
        return match[s.length()][p.length()];
    }
}