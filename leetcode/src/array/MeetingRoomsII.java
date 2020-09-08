package array;

import sun.jvm.hotspot.utilities.Interval;

import java.util.HashMap;
import java.util.Map;

public class MeetingRoomsII {
    public static void main(String[] args) {
//        Interval[] intervals = ScannerUtil.readIntervals();
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        System.out.println(getMeetingRooms(intervals));
    }

    public static int getMeetingRooms(Interval[] intervals) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (Interval interval : intervals) {
            int currStart = (int) interval.getLowEndpoint();
            start = Math.min(start, currStart);
            int currEnd = (int) interval.getHighEndpoint();
            end = Math.max(end, currEnd);
            if (!map.containsKey(currStart)) {
                map.put(currStart, 1);
            } else {
                map.put(currStart, map.get(currStart) + 1);
            }
            if (!map.containsKey(currEnd)) {
                map.put(currEnd, -1);
            } else {
                map.put(currEnd, map.get(currEnd) - 1);
            }

        }
        int result = 0;
        int curr = 0;
        for (int i = start; i <= end; i++) {
            curr += map.containsKey(i) ? map.get(i) : 0;
            result = Math.max(result, curr);
        }
        return result;
    }
}
