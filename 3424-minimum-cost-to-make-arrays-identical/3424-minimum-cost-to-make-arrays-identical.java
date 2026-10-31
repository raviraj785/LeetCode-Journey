
import java.util.Arrays;

class Solution {
    public long minCost(int[] arr, int[] brr, long k) {

        int n = arr.length;

        // Option 1: Without rearranging
        long cost1 = 0;

        for (int i = 0; i < n; i++) {
            cost1 += Math.abs(
                (long) arr[i] - brr[i]
            );
        }

        // Option 2: After rearranging
        int a[] = arr.clone();
        int b[] = brr.clone();

        Arrays.sort(a);
        Arrays.sort(b);

        long cost2 = k;

        for (int i = 0; i < n; i++) {
            cost2 += Math.abs(
                (long) a[i] - b[i]
            );
        }

        return Math.min(cost1, cost2);
    }
}
