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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        int start = intervals.get(0).start; 
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            // indicates that two intervals overlaps.
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                // no overlap, update previous into result list.
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}