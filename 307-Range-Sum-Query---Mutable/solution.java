public class NumArray {
    class SegTreeNode {
        private SegTreeNode left;
        private SegTreeNode right;
        private int start;
        private int end;
        private int sum;
        
        public SegTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    
    private final SegTreeNode root;
    
    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length-1);    
    }
    
    private SegTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        SegTreeNode root = new SegTreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
        } else {
            int mid = start + (end-start)/2;
            root.left = buildTree(nums, start, mid);
            root.right = buildTree(nums, mid+1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegTreeNode root, int i, int val) {
        // base case: reach a leaf node, update the sum value.
        if (root.start == root.end) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end-root.start)/2;
        if (i <= mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        } 
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegTreeNode root, int i, int j) {
        if (i == root.start && j == root.end) {
            return root.sum;
        } 
        int mid = root.start+(root.end-root.start)/2;
        // mid is the end index of root.left and start index-1 of root.right
        if (j <= mid) {
            return sumRange(root.left, i, j);
        } else if (i > mid) {
            return sumRange(root.right, i, j);
        } else {
            return sumRange(root.left, i, mid) + sumRange(root.right, mid+1, j);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);