import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Calculate NSE (Next Smaller Element)
        st.push(n - 1);
        nse[n - 1] = n;

        for (int i = n - 2; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        // Empty Stack
        while (!st.isEmpty()) {
            st.pop();
        }

        // Calculate PSE (Previous Smaller Element)
        st.push(0);
        pse[0] = -1;

        for (int i = 1; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        // Calculate Maximum Area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}