package Airbnb;


import common.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 *
 * Example 1:
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation:
 * There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * Example 2:
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)
 *
 * Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 *
 * Note:
 *
 * schedule and schedule[i] are lists with lengths in range [1, 50].
 * 0 <= schedule[i].start < schedule[i].end <= 10^8.
 */
public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        PriorityQueue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        for (List<Interval> list : schedule) {
            for (Interval interval : list) {
                pq.offer(interval);
            }
        }

        ArrayList<Interval> merged = new ArrayList<>();
        Interval last = null;

        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if (last == null || last.end < cur.start) {
                merged.add(cur);
                last = cur;
            } else {
                last.end = Math.max(cur.end, last.end);
            }
        }

        ArrayList<Interval> ret = new ArrayList<>();
        for (int i = 0; i < merged.size() - 1; ++i) {
            ret.add(new Interval(merged.get(i).end, merged.get(i+1).start));
        }

        return ret;
    }

    public List<List<Integer>> solve(int[][] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] a : arr) {
            pq.add(new int[]{a[0], 1});
            pq.add(new int[]{a[1], -1});
        }

        List<List<Integer>> ans = new ArrayList<>();
        Integer pre = null;
        int count = 0;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            if (count == 0 && node[1] == 1 && pre != null) {
                ans.add(Arrays.asList(pre, node[0]));
            } else if (count == 1 && node[1] == -1) {
                pre = node[0];
            }
            count += node[1];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] test1 = {{1,3}, {6,7}, {2,4}, {2,3}, {9,12}};

        EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
        for (List<Integer> list : employeeFreeTime.solve(test1)) {
            list.forEach(r->System.out.print(r+","));
            System.out.println("");
        }
    }
}
