// Last updated: 09/07/2026, 15:11:38
class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        for(int n:nums){
            if(n%3!=0){
                count++;
            }
            
        }
        return count++;
    }
}