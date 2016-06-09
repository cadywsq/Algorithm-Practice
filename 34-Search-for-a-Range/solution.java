public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] result = new int[2];
        
        result[0] = findFirstOccurrence(nums, target, start, end);
        result[1] = findLastOccurrence(nums, target, start, end);
        return result;
    }
    
    private int findFirstOccurrence(int[] nums, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        if (nums[start] != target) {
            return -1;
        }
        return start;
    }
    
    private int findLastOccurrence(int[] nums, int target, int start, int end) {
        //Set "start+1<end" other than "start<end" as loop condition.
        //Because we let "start = mid" in loop, start will never be equal to end.
        while (start+1 < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid;
            }
        }
        //Must first check end, because we are looking for last index.
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
    
}