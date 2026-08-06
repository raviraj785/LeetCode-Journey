class Solution {
    public int splitArray(int[] arr, int m) {
       
        if (arr.length < m) {
            return -1 ;
        }
        int st = 0;
       int end = 0;
        for (int x : arr) {
        st = Math.max(st, x);
        end += x;
        }
        int ans = end;
        while (st <= end) {
             int mid = st + (end - st) /2;
             if (isdivisionpossible(arr, m , mid)) {
                ans = mid ;
                 end = mid - 1;
                
             }
             else{
                st = mid +1;
             }
        }
        return ans;
    }

    
        static boolean isdivisionpossible(int arr [] , int m , int  mxchoclate){
        int noofstudent = 1;
        int choc = 0 ; // no of choclate has first student 
        for(int i = 0 ; i < arr.length ; i ++){
        if (arr[i] > mxchoclate) {
            return false;
        }
       if (choc + arr[i] <= mxchoclate) {
        choc+=arr[i];
       }
       else{
        noofstudent++;
        choc = arr[i];
       }

       }
       return noofstudent <= m;
    }
}


