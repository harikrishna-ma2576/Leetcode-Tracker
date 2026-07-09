// Last updated: 09/07/2026, 15:16:21
class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutations(0, nums,ans);
        return ans;
    }
    public void permutations(int i, int nums[], List<List<Integer>> ans){
        if (i == nums.length-1){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<nums.length; j++){
                temp.add(nums[j]);
            }
            ans.add(temp);
        }
        for (int j=i; j<nums.length; j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            permutations(i+1, nums,ans);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
