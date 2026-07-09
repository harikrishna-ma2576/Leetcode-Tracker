// Last updated: 09/07/2026, 15:11:58
class Solution {
    public int averageValue(int[] nums) {
        int sum=0;
        int count=0;
        for(int n:nums){
            if(n % 2 == 0 && n % 3 == 0){
            sum+=n;
            count++;
            }
       }
        if(count==0) return 0;
        return sum/count;
        
    }
}