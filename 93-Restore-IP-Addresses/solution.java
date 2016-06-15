public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        getIps(s, 0, "", result);
        return result;
    }
    
    private void getIps(String s, int index, String ip, List<String> result) {
        if (index >= s.length()) {
            if (ip.length() == s.length() + 4) {
                result.add(ip.substring(0, ip.length()-1));
            }
            return;
        }
        
        // one digit between two dots
        getIps(s, index+1, ip+s.charAt(index)+'.', result);
        
        if (s.charAt(index) != '0' && index+1 < s.length()) {
            // two digits between two dots
            getIps(s, index+2, ip+s.substring(index, index+2)+'.', result);
            
            // three digits between two dots
            if (index+2 < s.length()) {
                String threeNum = s.substring(index, index+3);
                if (threeNum.compareTo("255") <= 0) {
                    getIps(s, index+3, ip+threeNum+'.', result);
                }
            }
        }
    }
}