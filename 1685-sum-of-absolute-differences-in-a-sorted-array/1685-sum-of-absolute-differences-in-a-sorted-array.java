
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int result[] = new int[n];

        int totalSum = 0;

        for (int x : nums) {
            totalSum += x;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

            int x = nums[i];

            int left = (x * i) - leftSum;

            int right = (totalSum - leftSum - x)
                        - (x * (n - i - 1));

            result[i] = left + right;

            leftSum += x;
        }

        return result;
    }
}
