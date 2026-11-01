import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = profit.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort by end time
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {

            int low = 0, high = i;

            // Find compatible previous jobs
            while (low < high) {
                int mid = low + (high - low) / 2;

                if (jobs[mid][1] <= jobs[i][0]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            int take = jobs[i][2] + dp[low];
            int skip = dp[i];

            dp[i + 1] = Math.max(take, skip);
        }

        return dp[n];
    }
}