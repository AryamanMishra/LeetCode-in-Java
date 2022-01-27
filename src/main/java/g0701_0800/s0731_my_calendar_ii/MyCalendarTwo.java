package g0701_0800.s0731_my_calendar_ii;

// #Medium #Design #Ordered_Set #Segment_Tree

import java.util.TreeMap;

public class MyCalendarTwo {
    private final TreeMap<Integer, Integer> map;
    private final TreeMap<Integer, Integer> overlap;

    public MyCalendarTwo() {
        map = new TreeMap<>();
        overlap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer ol = overlap.lowerKey(end);
        if (ol == null || overlap.get(ol) <= start) {
            while (true) {
                Integer lower = map.lowerKey(end);
                if (lower == null || map.get(lower) <= start) {
                    break;
                }
                overlap.put(Math.max(start, lower), Math.min(end, map.get(lower)));
                start = Math.min(start, lower);
                end = Math.max(end, map.get(lower));
                map.remove(lower);
            }
            map.put(start, end);
            return true;
        }
        return false;
    }
}
