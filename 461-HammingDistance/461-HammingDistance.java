// Last updated: 09/07/2026, 15:13:19
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);       
    }
}