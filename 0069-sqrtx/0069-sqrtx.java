class Solution {
    public int mySqrt(int x) {
        int st = 0 ;
        int end = x ;
        int ans =-1;
        while(st <= end){
            int mid = st + (end - st) / 2 ;
            long val = (long) mid * mid ; 
            if(val == x){
                return mid;
            }
            else if (val < x ){
             ans = mid;
             st = mid+1;
            } 
            else{
                end = mid -1;
            }
        } 
        return ans;
    }
}