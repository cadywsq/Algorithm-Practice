public class Solution {
    class Element {
        private int i;
        private int j;
        private int val;
        
        public Element(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Element> heap = new PriorityQueue<>((e1,e2) -> e1.val-e2.val);
        // offer the first row value into the queue.
        for (int i = 0; i < n; i++) {
            heap.offer(new Element(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k-1; i++) {
            Element e = heap.poll();
            // if it's the last row
            if (e.i == n-1) {
                continue;
            }
            heap.offer(new Element(e.i+1, e.j, matrix[e.i+1][e.j]));
        }
        return heap.poll().val;
    }
}