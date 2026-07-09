// Last updated: 09/07/2026, 15:11:47
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
    int iCount = 0;
    for(int i = 0; i < hours.length; i++){
        if(hours[i] >= target)
        {iCount++;}}
    return iCount;
}
}