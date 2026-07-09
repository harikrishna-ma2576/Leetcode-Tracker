// Last updated: 09/07/2026, 15:11:41
class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int largest=0;
        int smallest=0;
        int n=nums.length;
        for(int i=0;i<k;i++){
            smallest+=nums[i];
        }
        for(int i=n-1;i>=n-k;i--){
            largest+=nums[i];
        }
        return Math.abs(largest-smallest);
    }
}