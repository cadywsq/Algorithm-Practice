public class Logger {
    
    private final Map<String, Integer> msgStore;
    
    /** Initialize your data structure here. */
    public Logger() {
        msgStore = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!msgStore.containsKey(message) || timestamp - msgStore.get(message) >= 10) {
            msgStore.put(message, timestamp);
            return true;
        } 
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */