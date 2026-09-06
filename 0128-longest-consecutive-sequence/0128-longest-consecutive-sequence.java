import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> st = new HashSet<>();

        // Put all elements into HashSet
        for (int num : nums) {
            st.add(num);
        }

        int maxStreak = 0;

        // Check every number
        for (int num : st) {

            // num is the starting point
            if (!st.contains(num - 1)) {

                int currNum = num;
                int currStreak = 1;

                // Find consecutive numbers
                while (st.contains(currNum + 1)) {
                    currStreak++;
                    currNum++;
                }

                maxStreak = Math.max(maxStreak, currStreak);
            }
        }

        return maxStreak;
    }
}