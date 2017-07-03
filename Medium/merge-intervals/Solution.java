import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        List<Interval> merged = new LinkedList<Interval>(intervals);
        Collections.sort(merged, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Iterator<Interval> it = merged.iterator();
        Interval prev = it.next();

        Interval next = null;
        while (it.hasNext()) {
            next = it.next();
            if (next.start <= prev.end) {
                if (next.end > prev.end) {
                    prev.end = next.end;
                }
                it.remove();
            } else {
                prev = next;
            }
        }
        return merged;
    }
}