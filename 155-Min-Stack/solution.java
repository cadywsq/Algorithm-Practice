public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        }
        // be careful that also need to push to minStack if equals min value.
        else if (x <= minStack.peek()) { 
            minStack.push(x);
        }
    }
    
    public void pop() {
        int value = stack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */