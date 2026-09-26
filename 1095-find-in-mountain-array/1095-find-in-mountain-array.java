class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int n = mountainArr.length();

        // 1. Find peak
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // Increasing part
                lo = mid + 1;
            } else {
                // Decreasing part
                hi = mid;
            }
        }

        int peak = lo;

        // 2. Search in increasing part
        lo = 0;
        hi = peak;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            } 
            else if (value < target) {
                lo = mid + 1;
            } 
            else {
                hi = mid - 1;
            }
        }

        // 3. Search in decreasing part
        lo = peak + 1;
        hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            } 
            else if (value > target) {
                // Descending array
                lo = mid + 1;
            } 
            else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}