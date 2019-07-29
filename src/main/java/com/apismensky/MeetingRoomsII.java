package com.apismensky;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 * Algorithm
 *
 * Sort the given meetings by their start time.
 * Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
 * For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
 * If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
 * If not, then we allocate a new room and add it to the heap.
 * After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
 */
public class MeetingRoomsII {
    private static class Interval implements Comparable<Interval> {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Interval interval = (Interval)o;
            return left == interval.left &&
                   right == interval.right;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }

        @Override
        public String toString() {
            return "Interval{" +
                   "left=" + left +
                   ", right=" + right +
                   '}';
        }

        @Override
        public int compareTo(Interval o) {
            return this.left - o.left;
        }
    }

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        List<Interval> list = Arrays
            .stream(intervals)
            .map(interval -> new Interval(interval[0], interval[1]))
            .sorted()
            .collect(Collectors.toList());
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o.right));
        pq.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Interval currentMeeting = pq.peek(); // Current ongoing meeting
            Interval interval = list.get(i);
            if (currentMeeting.right <= interval.left) {
                pq.poll();
            }
            pq.add(interval);
        }
        return pq.size();
    }
}
