import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // Convert int array into String array
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom Comparator
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        // Edge case: All elements are zero
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (String s : arr) {
            ans.append(s);
        }

        return ans.toString();
    }
}