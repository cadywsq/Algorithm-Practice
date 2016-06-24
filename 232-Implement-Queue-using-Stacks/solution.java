class MyQueue {
    private final Stack<Integer> storeStack;
    private final Stack<Integer> queueStack;
    
    public MyQueue() {
        storeStack = new Stack<>();
        queueStack = new Stack<>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        storeStack.push(x);    
    }

    // Removes the element from in front of queue.
    public void pop() {
        depleteStore();
        
        if (queueStack.isEmpty()) {
            return;
        }
        queueStack.pop();
    }

    // Get the front element.
    public int peek() {
        depleteStore();
        return queueStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        depleteStore();
        return queueStack.isEmpty();
    }
    
    private void depleteStore() {
        if (queueStack.isEmpty()) {
            while (!storeStack.isEmpty()) {
                queueStack.push(storeStack.pop());
            }
        }
    }
}