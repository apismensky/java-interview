package com.apismensky;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class RectangeOverlap {

    private static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;

        }
        int x,y;

        @Override
        public String toString() {
            return "Point{" +
                   "x=" + x +
                   ", y=" + y +
                   '}';
        }
    }

    public static class Rectangle {
        Point bottomLeft;
        Point topRight;
        public Rectangle(Point bottomLeft, Point topRight) {
            // validate input
            if (bottomLeft.x > topRight.x || bottomLeft.y > topRight.x) {
                throw new IllegalArgumentException("Invalid input coordinates bottomLeft: " + bottomLeft + ", topRight: " +
                                                   topRight);
            }
            this.bottomLeft = bottomLeft;
            this.topRight = topRight;
        }

        public boolean isOverlap(Rectangle other) {
            if (other == null)
                return false;

            boolean case1 = this.topRight.x >= other.bottomLeft.x && this.bottomLeft.y <= other.topRight.y;
            System.out.println(case1);
            boolean case2 = this.topRight.x >= other.bottomLeft.x && this.topRight.y >= other.bottomLeft.y;
            System.out.println(case2);
            boolean case3 = this.bottomLeft.x <= other.topRight.x && this.bottomLeft.y <= other.topRight.y;
            System.out.println(case3);
            boolean case4 = this.bottomLeft.x <= other.topRight.x && this.topRight.y >= other.bottomLeft.y;
            System.out.println(case4);
            return case1 ||
                   case2 ||
                   case3 ||
                   case4;

        }
    }

    @Test
    public void test1() {
        Rectangle r1 = new Rectangle(new Point(2,2), new Point(4,4));
        Rectangle r2 = new Rectangle(new Point(3, 1), new Point(5, 4));
        assertTrue(r2.isOverlap(r1));
    }

    @Test
    public void test2() {
        Rectangle r1 = new Rectangle(new Point(1,1), new Point(2,2));
        Rectangle r2 = new Rectangle(new Point(3, 3), new Point(4, 4));
        assertFalse(r2.isOverlap(r1));
    }
}
