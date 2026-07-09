// Last updated: 09/07/2026, 15:11:51
class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int t=arrivalTime+delayedTime;
        return t%24;
    }
}