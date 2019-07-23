package com.apismensky;

import static com.apismensky.MeetingRoomsII.minMeetingRooms;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MeetingRoomsIITest {

    @Test
    public void test1() {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        assertEquals(2, minMeetingRooms(intervals));
    }

    @Test
    public void test2() {
        int[][] intervals = {{7, 10}, {2, 4}};
        assertEquals(1, minMeetingRooms(intervals));
    }

    @Test
    public void test3() {
        int[][] intervals = {{9,10},{4,9},{4,17}};
        assertEquals(2, minMeetingRooms(intervals));
    }
}
