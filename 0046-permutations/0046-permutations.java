class Solution {
public void helper(int [] nums , List<Integer>ds , boolean[] isValid,List<List<Integer>> ans){
    int n = nums.length;
    if(ds.size()==n){
        List<Integer> List = new ArrayList<>();
        for(int i = 0; i <ds.size() ; i++){
            List.add(ds.get(i));
        }
        ans.add(List);
        return ;

    }
    for(int i = 0; i <nums.length ; i++){
        if(isValid [i] == false ){
            ds.add(nums[i]);
            isValid[i] = true;
             helper(nums, ds ,isValid ,ans);
             isValid[i] = false;
             ds.remove(ds.size() -1 );
        }
    }
}
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>() ;
        boolean[] isValid = new boolean [nums.length];
        helper(nums, ds ,isValid ,ans);
        return ans;
    }
}