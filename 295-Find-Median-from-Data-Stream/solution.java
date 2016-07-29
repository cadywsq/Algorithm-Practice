public class MedianFinder {
    private final PriorityQueue<Integer> leftMax;
    private final PriorityQueue<Integer> rightMin;
    
    public MedianFinder() {
        leftMax = new PriorityQueue<>((o1, o2) -> o2-o1);
        rightMin = new PriorityQueue<>();
    }
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (leftMax.isEmpty()) {
            leftMax.offer(num);
            return;
        }
        if (num < leftMax.peek()) {
            leftMax.offer(num);
        } else {
            rightMin.offer(num);
        }
        // balance two heaps
        if (leftMax.size() - rightMin.size() > 1) {
            rightMin.offer(leftMax.poll());
        } else if (rightMin.size() - leftMax.size() > 1) {
            leftMax.offer(rightMin.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (leftMax.size() == rightMin.size()) {
            return (leftMax.peek() + rightMin.peek()) / 2.0;
        } else {
            return leftMax.size() > rightMin.size() ? leftMax.peek() : rightMin.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();