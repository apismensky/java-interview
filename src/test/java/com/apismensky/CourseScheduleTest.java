package com.apismensky;

import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {

    @Test
    public void testNoPrerequisites() {
        assertTrue(CourseSchedule.canFinish(2, new int[][]{}));
    }

    @Test
    public void testZeroCourses() {
        assertTrue(CourseSchedule.canFinish(0, new int[][]{ {1,0} }));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumCourses() {
        assertTrue(CourseSchedule.canFinish(-2, new int[][]{}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPrerequisites() {
        assertTrue(CourseSchedule.canFinish(2, new int[][]{ {1,0,0} }));
    }

    @Ignore
    public void testCan() {
        assertTrue(CourseSchedule.canFinish(2, new int[][]{{1, 0}}));
    }

    @Ignore
    public void testCan2() {
        assertTrue(CourseSchedule.canFinish(5, new int[][]{{0,1}, {1,5}, {1,2}, {2,4}}));
    }

    @Ignore
    public void testCant() {
        assertFalse(CourseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

}
