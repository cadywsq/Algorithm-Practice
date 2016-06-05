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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        
        List<Interval> result = new ArrayList<>();
        int insertPos = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                // if curInterval is to the left of newInterval, add cur to list.
                result.add(interval);
                insertPos++;
            } else if (interval.start > newInterval.end) {
                //The interval is at right of new interval.
                result.add(interval);
            } else {
                //The interval has intersection with new interval, merge them, and update start & end of new interval.
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
                
            }
        }
        //Insert new interval
        result.add(insertPos, newInterval);
        return result;
    }
}