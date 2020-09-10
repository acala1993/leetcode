package array;

import sun.jvm.hotspot.utilities.Interval;

import java.util.HashMap;
import java.util.Map;

public class MeetingRooms {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        System.out.println(findMeetingRooms(intervals));
    }

    public static boolean findMeetingRooms(Interval[] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        int minStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            int start = (int) interval.getLowEndpoint();
            minStart = Math.min(minStart, start);
            int end = (int) interval.getHighEndpoint();
            maxEnd = Math.max(maxEnd, end);
            if (map.containsKey(start)) {
                map.put(start, map.get(start) + 1);
            } else {
                map.put(start, 1);
            }

            if (map.containsKey(end)) {
                map.put(end, map.get(end) - 1);
            } else {
                map.put(end, -1);
            }
        }
        int curr = 0;
        int max = 0;
        for (int i = minStart; i <= maxEnd; i++) {
            if (map.containsKey(i)) {
                curr += map.get(i);
            }
            max = Math.max(max, curr);
        }
        return max == 1;
    }
}
