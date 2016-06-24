public class Solution {
    public int bulbSwitch(int n) {
        // find count of squares.
        int count = 0;
        while (count*count < n) {
            count++;
        }
        return count*count == n ? count : (count-1);
    }
}