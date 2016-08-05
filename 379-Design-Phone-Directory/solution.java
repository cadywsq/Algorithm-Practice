public class PhoneDirectory {
    private final Set<Integer> used;
    private final List<Integer> idle;
    private int maxNum;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        // ensures O(1) time for contains method
        used = new HashSet<>();
        // ensures O(1) time for delete method
        idle = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            idle.add(i);
        }
        maxNum = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (!idle.isEmpty()) {
            used.add(idle.get(0));
            return idle.remove(0);
        }
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= maxNum || number < 0) {
            return false;
        }
        return !used.contains(number); 
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number)) {
            idle.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */