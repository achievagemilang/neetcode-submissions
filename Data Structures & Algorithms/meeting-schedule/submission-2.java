/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) return true;
        
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int j=1; j<intervals.size(); j++){
            Interval i = intervals.get(j);
            if(isConflict(start, end, i)){
                return false;
            }

            if(start > i.start) start = i.start;
            if(end < i.end) end = i.end;

        }

        return true;
    }

    public boolean isConflict(int start, int end, Interval i){
        if((i.start >= start && i.start < end)
            || i.end >= start && i.end < end) return true;

        return false;
    }
}
