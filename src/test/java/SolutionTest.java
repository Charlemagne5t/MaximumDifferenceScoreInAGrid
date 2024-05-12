import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1() {
        List<List<Integer>> grid = new ArrayList<>(
                List.of(List.of(4,3),
                        List.of(2,3))
        );
        int expected = 1;
        int actual = new Solution().maxScore(grid);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        List<List<Integer>> grid = new ArrayList<>(
                List.of(List.of(4,9),
                        List.of(5,2),
                        List.of(3,1))
        );
        int expected = 5;
        int actual = new Solution().maxScore(grid);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test3() {
        List<List<Integer>> grid = new ArrayList<>(
                List.of(List.of(9,4,2,5,10),
                        List.of(6,7,2,3,10),
                        List.of(1,3,4,10,7),
                        List.of(2,6,7,3,4),
                        List.of(8,3,8,1,1))
                );

        int expected = 9;
        int actual = new Solution().maxScore(grid);
        Assert.assertEquals(expected, actual);
    }
}
