import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m][n];
        int res = Integer.MIN_VALUE;
        int[] mins = new int[n];
        int min = grid.get(0).get(0);
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = grid.get(0).get(i) - min;
            res = Math.max(res, dp[0][i]);
            if (dp[0][i] < 0) {
                dp[0][i] = 0;
            }
            min = Math.min(grid.get(0).get(i), min);

        }
        Arrays.fill(mins, Integer.MAX_VALUE);


        for (int i = 1; i < m; i++) {
            int minRow = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                mins[j] = Math.min(j == 0 ? Integer.MAX_VALUE : mins[j - 1], mins[j]);
                mins[j] = Math.min(mins[j], grid.get(i - 1).get(j) - dp[i - 1][j]);
                dp[i][j] = grid.get(i).get(j) - mins[j];
                dp[i][j] = Math.max(dp[i][j], j == 0 ? Integer.MIN_VALUE : grid.get(i).get(j) - grid.get(i).get(j - 1));
                dp[i][j] = Math.max(dp[i][j], grid.get(i).get(j) - minRow);
                minRow = Math.min(grid.get(i).get(j), minRow);
                res = Math.max(res, dp[i][j]);
                if (dp[i][j] < 0) {
                    dp[i][j] = 0;
                }
            }
        }


        return res;
    }
}