class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = firstoccurence(nums, target);
        int last = lastoccurence(nums, target);

        return new int[]{first, last};
    }

    static int firstoccurence(int arr[], int target) {
        int fo = -1;
        int st = 0;
        int end = arr.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (arr[mid] == target) {
                fo = mid;
                end = mid - 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return fo;
    }

    static int lastoccurence(int arr[], int target) {
        int lo = -1;
        int st = 0;
        int end = arr.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (arr[mid] == target) {
                lo = mid;
                st = mid + 1;
            } else if (target > arr[mid]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return lo;
    }
}