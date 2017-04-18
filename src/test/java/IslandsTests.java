import com.apismensky.Islands;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandsTests {

    @Test
    public void test1() {
        assertEquals(2, Islands.findIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'},
        }));
    }

    @Test
    public void test2() {
        assertEquals(3, Islands.findIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '1', '0', '0', '0'}
        }));
    }

    @Test
    public void test3() {
        assertEquals(4, Islands.findIslands(new char[][]{
                {'0', '0', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1'},
                {'0', '1', '0', '1', '0', '1'},
                {'0', '0', '0', '1', '0', '0'}
        }));
    }

    @Test
    public void test0() {
        assertEquals(0, Islands.findIslands(new char[][]{}));
    }


    @Test
    public void test4() {
        assertEquals(3, Islands.findIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }


}
