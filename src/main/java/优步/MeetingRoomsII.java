package 优步;


import common.Interval;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), findWithDuplicates the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoomsII {

    /**
     * SELF
     * @param intervals
     * @return
     */
    public int minMeetingRoomsSelf(Interval[] intervals) {
        List<Stack<Integer>> ret = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return ret.size();
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        for (Interval interval : intervals) {
            if (ret.isEmpty()) {
                Stack<Integer> stack = new Stack<>();
                stack.push(interval.end);
                ret.add(stack);
            } else {
                boolean isAdded = false;
                for (Stack<Integer> stack : ret) {
                    int end = stack.peek();
                    if (interval.start >= end) {
                        stack.push(interval.end);
                        isAdded = true;
                        break;
                    }
                }

                if (!isAdded) {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(interval.end);
                    ret.add(stack);
                }
            }
        }
        return ret.size();
    }


    /**
     * MinHeap + PriorityQueue
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<Interval>() {
                    public int compare(Interval a, Interval b) {
                        return a.start - b.start;
                    }
                });

        // Add the first meeting
        allocator.add(intervals[0].end);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i].start >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i].end);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] inter : intervals) {
            pq.add(new int[]{inter[0], 1});
            pq.add(new int[]{inter[1], -1});
        }

        int ans = 0, sum = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            sum += cur[1];
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
