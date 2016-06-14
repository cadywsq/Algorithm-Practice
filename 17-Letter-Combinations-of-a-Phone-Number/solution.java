public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Character, String> numMap = new HashMap<>();
        numMap.put('2',"abc");
        numMap.put('3',"def");
        numMap.put('4',"ghi");
        numMap.put('5',"jkl");
        numMap.put('6',"mno");
        numMap.put('7',"pqrs");
        numMap.put('8',"tuv");
        numMap.put('9',"wxyz");
        
        getCombinations(digits, 0, "", numMap, result);
        return result;
    }
    
    private void getCombinations(String digits, int index, String s, Map<Character, String> numMap, List<String> result) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }
        String chars = numMap.get(digits.charAt(index));
        for (char c : chars.toCharArray()) {
            getCombinations(digits, index+1, s+c, numMap, result);
        }
    }
}