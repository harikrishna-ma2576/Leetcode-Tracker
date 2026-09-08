// Last updated: 08/09/2026, 10:12:14
1// Finds the nth super ugly number given a list of prime numbers.
2
3class Solution {
4public:
5    int nthSuperUglyNumber(int n, vector<int>& primes) {
6        if (n == 1)
7            return 1;
8
9        int numPrimes = primes.size();  // Number of prime numbers
10        vector<int> primeIndices(numPrimes, 0);  // Indices to track prime number multiples
11
12        int superUgly[n];  // Array to store super ugly numbers
13        // memset(superUgly, 0, sizeof(superUgly));  // Initialize the array (commented out since it's unnecessary)
14        superUgly[0] = 1;  // First super ugly number is always 1
15
16        for (int i = 1; i < n; i++) {
17            long minVal = INT_MAX;  // Minimum value among the prime number multiples
18
19            // Find the minimum value among the prime number multiples
20            for (int j = 0; j < numPrimes; j++) {
21                minVal = min(minVal, (long)primes[j] * superUgly[primeIndices[j]]);
22            }
23
24            superUgly[i] = (int)minVal;  // Store the minimum value as the next super ugly number
25
26            // Increment the indices for prime number multiples that contribute to the minimum value
27            for (int j = 0; j < numPrimes; j++) {
28                if (minVal == (long)primes[j] * superUgly[primeIndices[j]]) {
29                    primeIndices[j]++;
30                }
31            }
32
33            // cout<<superUgly[i]<<",";  // Print the current super ugly number (commented out for clarity)
34        }
35
36        return superUgly[n - 1];  // Return the nth super ugly number
37    }
38};