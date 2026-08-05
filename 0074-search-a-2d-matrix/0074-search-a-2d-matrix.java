class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        // N = number of Row 
        int n = arr.length;
         // M = no of Column
         int m = arr[0].length;

         int st = 0 ;
         int end = n*m-1;
         while(st <= end ){
            int mid = st + (end - st ) / 2 ;
            // mid element in two d array 
            int midelement = arr[mid / m ][mid % m];
             if(target == midelement){
                return true;
             }
             // Agar Hamara Target Mid Se Piche Ho To 
             if(target < midelement){
                // End Ko piche Kr do 
                  end = mid -1;
             }
              // Agar Hamara Target Mid Se Aage Ho To St ko aage badha do
              else{
                st = mid+1;
              }

         }
         return false;
    }
}