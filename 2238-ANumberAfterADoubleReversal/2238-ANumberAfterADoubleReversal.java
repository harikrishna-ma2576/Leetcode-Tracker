// Last updated: 09/07/2026, 15:12:02
class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num==0){
            return true;
        }else{
            if(num%10==0){
                return false;
            }else{
                return true;
            }
        }

    }
}