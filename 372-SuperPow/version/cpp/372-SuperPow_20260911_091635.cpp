// Last updated: 11/09/2026, 09:16:35
1class Solution {
2public:
3    int getMoneyAmount(int n) {
4        vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
5        
6        //dp[i][j] - the amount of money needed for guaranteed win,
7        // when range is [i, j] (note: both are inclusive)
8        for(int l = 1; l <= n; l++)
9        {
10            for(int i = 0; i+l-1 <= n; i++)
11            {
12                
13                if(l==1)
14                {
15                    // if length = 1, then the only number guessed is correct, no penalty
16                    dp[i][i+l-1] = 0; 
17                }
18                else if(l==2)
19                {
20                    // if length = 2, guess the lower number, 
21                    // if it's not correct then the other number will be the correct one
22                    // so max amount to guarantee win is the lower of two numbers
23                    dp[i][i+l-1] = i; 
24                }
25                else
26                {
27                    int ans = INT_MAX;
28                    // if you guess a number j between i, i+l-1
29                    // then cost will be j + max of the money required to guarantee win on the either side
30                    for(int j = i+1; j < i+l-1; j++)
31                    {
32                         ans = min(ans, j + max(dp[i][j-1], dp[j+1][i+l-1]));
33                    }
34                    
35                    dp[i][i+l-1] = ans;
36                }
37            }
38        }
39        
40        return dp[1][n];
41    }
42};