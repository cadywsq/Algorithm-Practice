public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> intersection = new HashSet<>();
        solution1(nums1, nums2, intersection);
        int[] result = new int[intersection.size()];
        int count = 0;
        for (int value:intersection) {
            result[count++] = value;
        }
        return result;
    }
    
    // Solution1: hashSet, extra space
    // use one hashSet to store value of first array, another to store unique intersect values. 
    // O(m+n) time, worst case O(m + min(m,n)) space
    private void solution1(int[] nums1, int[] nums2, Set<Integer> intersection) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }
    }
    
    // Solution2: use two pointer if two arrays are sorted
    // O(m+n) time, O(1) space except for set to store intersected part.
    private void solution2(int[] nums1, int[] nums2, Set<Integer> intersection) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                intersection.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
    }
    
    // Solution3: use binary search on longer array if it's sorted
    // sort the longer array, use binary search to check whether each element is an intersection
    // O(mlogn) time after sort (n<m)
    private void solution3(int[] nums1, int[] nums2, Set<Integer> intersection) {
        if (nums1.length > nums2.length) {
            solution3Helper(nums1, nums2, intersection);
        } else {
            solution3Helper(nums2, nums1, intersection);
        }
    }
    
    private void solution3Helper(int[] longer, int[] shorter, Set<Integer> intersection) {
        Arrays.sort(longer);
        for (int i = 0; i < shorter.length; i++) {
            if (binarySearch(longer, shorter[i])) {
                intersection.add(shorter[i]);
            }
        }
    }
    
    private boolean binarySearch(int[] longer, int target) {
        int start = 0;
        int end = longer.length;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (longer[mid] < target) {
                start = mid+1;
            } else if (longer[mid] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        return target == longer[start];
    }
}