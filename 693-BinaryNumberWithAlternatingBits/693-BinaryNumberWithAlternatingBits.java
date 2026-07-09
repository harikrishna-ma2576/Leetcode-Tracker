// Last updated: 09/07/2026, 15:12:38
class Solution {
    public boolean hasAlternatingBits(int n) {
          int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}