public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> numMap = new HashMap<>();
        char[] secretNum = secret.toCharArray();
        char[] guessNum = guess.toCharArray();
        for (char c : secretNum) {
            int count = 1;
            if (numMap.containsKey(c)) {
                count = numMap.get(c)+1;
            }
            numMap.put(c, count);
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secretNum.length; i++) {
            Integer count = numMap.get(guessNum[i]);
            if (secretNum[i] == guessNum[i]) {
                bull++;
                numMap.put(guessNum[i], count-1);
                // edge case: 1122 Vs. 1222, proritize bull count.
                if (count <= 0) {
                    cow--;
                }
            } else {
                if (numMap.containsKey(guessNum[i]) && count > 0) {
                    cow++;
                    numMap.put(guessNum[i], count-1);
                }
            }
        }
        return bull + "A" + cow + "B";
    }
}