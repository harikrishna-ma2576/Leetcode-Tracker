// Last updated: 11/09/2026, 09:14:11
1public class Solution extends GuessGame 
2{
3    public int guessNumber(int n) 
4    {
5        long s = 1;
6        while (s <= n)
7        {
8            int x = (int)((n + s) / 2);
9            int g = guess(x);
10            if (g == 0)  return x;
11            if (g < 0)   n = x - 1;
12            if (g > 0)   s = x + 1;
13        }
14        return -1;
15    }
16}