public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return solution3(nums, k, t);
    }
    
    /**Solution1: keep a virtual sliding window that holds the newest k elements.
     * O(n*min(k, n)) time complexity
     */
    private boolean solution1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(0, i-k); j < i; j++) {
                if (Math.abs(nums[i]-nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**Solution2: If elements in the window are in sorted order, we can apply Binary Search twice to search for the two boundaries x+t and x-t for each element x.
     * Self-balancing Binary Search Tree (BST) is the right data structure.
     *  (1) Initialize an empty BST set
        (2) Loop through the array, for each element x
            a. Find the smallest element s in set that is greater than or equal to x
            b. Find the greatest element gg in set that is smaller than or equal to x
        (3) Put x in set
        (4) If the size of the set is larger than k, remove the oldest item.
    * 
    * Time complexity O(nlog(min(k,n))), Space Complexity O(min(k,n))
    */
    private boolean solution2(int[] nums, int k, int t) {
        TreeSet<Integer> balancedBST = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // find successor of nums[i]
            Integer successor = balancedBST.ceiling(nums[i]);
            if (successor != null && successor - nums[i] <= t) {
                return true;
            }
            // find predecessor of nums[i]
            Integer predecessor = balancedBST.floor(nums[i]);
            if (predecessor != null && nums[i] - predecessor <= t) {
                return true;
            }
            
            balancedBST.add(nums[i]);
            
            if (balancedBST.size() > k) {
                balancedBST.remove(nums[i-k]);
            }
        }
        return false;
    }
    
    /**Solution3: apply the bucketing principle and design buckets covering the ranges of 
     * [0,t],[t+1,2t+1],.... We keep the window using this buckets. 
     * Then, each time, all we need to check is the bucket that x belongs to and its two adjacent buckets. 
     * One thing worth mentioning is the difference from bucket sort 
     *  – Each of our buckets contains at most one element at any time, because two elements in a bucket means "almost duplicate" and we can return early from the function. 
     * Therefore, a HashMap with an element associated with a bucket label is enough for our purpose.
     * Time Complexity O(n), Space Complexity O(min(k,n))
     */
     private boolean solution3(int[] nums, int k, int t) {
         if (t < 0) {
             return false;
         }
         Map<Long, Long> buckets = new HashMap<>();
         long width =(long)t+1;
         for (int i = 0; i < nums.length; i++) {
             long bucket = getID(nums[i], width);
             // if two nums within one bucket, they are almost duplicates.
             if (buckets.containsKey(bucket)) {
                 return true;
             }
             // check the neighbor buckets for almost duplicates.
             if (buckets.containsKey(bucket-1) && nums[i]-buckets.get(bucket-1) <= t) {
                 return true;
             }
             if (buckets.containsKey(bucket+1) && buckets.get(bucket+1)-nums[i] <= t) {
                 return true;
             }
             // bucket is empty and no almost neighbors
             buckets.put(bucket, (long)nums[i]);
             // remove if more than k numbers in buckets
             if (i >= k) {
                 buckets.remove(getID(nums[i-k], width));
             }
         }
         return false;
     }
     
     private long getID(long num, long width) {
         // In Java, `-3 / 5 = 0`, but we need `-3 / 5 = -1`.
         return num < 0 ? (num+1)/width - 1 : num/width;
     }

}