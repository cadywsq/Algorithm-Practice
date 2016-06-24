class MyStack {
    private final Queue<Integer> queueStack = new LinkedList<>();
    // Push element x onto stack.
    // Push operation is expensive in this implementation, can also make pop() expensive
    public void push(int x) {
        queueStack.offer(x);
        for (int i = 1; i < queueStack.size(); i++) {
            // push back to the same queue again except for the just added element, thus the last added one is at the top.
            queueStack.offer(queueStack.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queueStack.poll();
    }

    // Get the top element.
    public int top() {
        return queueStack.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queueStack.isEmpty();
    }
}