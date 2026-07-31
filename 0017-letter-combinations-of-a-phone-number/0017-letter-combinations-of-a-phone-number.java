import java.util.*;

class Solution {

    List<String> ans = new ArrayList<>();

    String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return ans;

        backtrack(digits, 0, "");

        return ans;
    }

    public void backtrack(String digits, int idx, String curr) {

        // Base Case
        if (idx == digits.length()) {
            ans.add(curr);
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, idx + 1, curr + letters.charAt(i));
        }
    }
}