class Solution {
    public void sortColors(int[] nums) {
        int low = 0 ;
        int mid = 0 ;
        int high = nums.length -1;
        while(mid <= high){
            if(nums[mid] == 0 ){
                swap(nums, mid , low);
                mid++;
                low++;
            }
            else if (nums[mid] == 1){
              mid++;
            }
            else{
                swap(nums, mid , high);
                high--;
            }
        }
    }
    static void swap(int nums[] , int x , int y ){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}