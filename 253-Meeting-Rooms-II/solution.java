/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        return twoPointerSolution(intervals);
    }
    
    /**Solution1: Two Pointers*/
    public int twoPointerSolution(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int endPointer = 0;
        int room = 0;
        
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endPointer]) {
                room++;
            } else {
                endPointer++;
            }
        }
        return room;
    }
    
    /**Solution2: Heap*/
    public int heapSolution(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> a.start-b.start);
        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end-b.end);
        
        // start with the first meeting, put it to a meeting room
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = minHeap.peek();
            if (intervals[i].start < interval.end) {
                minHeap.offer(intervals[i]); // the meeting needs a new room
            } else {
                interval.end = intervals[i].end; // no need for a new room, merge intervals
            }
        }
        return minHeap.size();
    }
}