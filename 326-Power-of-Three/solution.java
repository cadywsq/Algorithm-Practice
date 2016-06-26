public class Solution {
    public boolean isPowerOfThree(int n) {
        return solution4(n);
    }
    
    private boolean solution1(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
    
    /**Solution2: if we convert our number to base 3 and the representation is having just one digit of 1 and everything else 0 means the number is a power of 3.
     */
    private boolean solution2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
    
    /**Solution3: n is a power of three if and only if i is an integer. 
     * In Java, we check if a number is an integer by taking the decimal part (using % 1) and checking if it is 0.
     */
    private boolean solution3(int n) {
        //the result of Math.log10(n) / Math.log10(3) could be 5.0000001 or 4.9999999
        double epsilon = Math.pow(10, -6);
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2*epsilon;
    }
    
    /**Solution4: The maximum value of this data type is 2147483647. 
     * Knowing the limitation of n, we can now deduce that the maximum value of n that is also a power of three is 1162261467. 
     * therefore all we need to do is divide 3^19 by n. 
     * A remainder of 0 means n is a divisor of 3^19 and therefore a power of three.
     */
     private boolean solution4(int n) {
         return n > 0 && ((int) Math.pow(3, 19) % n == 0);
     }
}