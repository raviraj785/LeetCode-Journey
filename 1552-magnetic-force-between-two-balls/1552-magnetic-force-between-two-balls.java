
class Solution {
    public int maxDistance(int[] arr, int k) {
        Arrays.sort(arr);
        
    if (k > arr.length) {
        return -1;
    }
    int st = 1;
    int end = arr[arr.length - 1] - arr[0];
    int ans = -1;
    while (st <= end) {

        int mid = st + (end - st) / 2;

        if (ispossible(arr, k, mid)) {
            ans = mid;
            st = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return ans;
        }
    static boolean ispossible(int arr [] , int k , int dist){
        int kidsplace = 1;
        int lastkid = arr[0];
        for(int i = 1; i < arr.length ; i++){
            if (arr[i] -lastkid >= dist) {
                kidsplace ++;
                lastkid = arr[i];
            }
        }
        return kidsplace >= k;
    }

   
} 
   