// Last updated: 09/07/2026, 15:13:51
class Solution {
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int count=0;
        while(n!=0){
            n&=(n-1);
            count+=1;
            
        }
        return count;
    }
}