// Last updated: 09/07/2026, 15:12:17
class Solution {
    public int minCostToMoveChips(int[] position) {
        int oddCount=0;
        int evenCount=0;
        for(int n:position){
            if(n%2==0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        return evenCount<oddCount?evenCount:oddCount;
        
    }
}