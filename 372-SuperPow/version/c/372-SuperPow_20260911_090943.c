// Last updated: 11/09/2026, 09:09:43
1int modPow(int base, int exp, int mod) {
2    long long result = 1;
3    long long b = base % mod;
4    while (exp > 0) {
5        if (exp % 2 == 1)
6            result = (result * b) % mod;
7        b = (b * b) % mod;
8        exp /= 2;
9    }
10    return (int)result;
11}
12
13int superPow(int a, int* b, int bSize) {
14    int mod = 1337;
15    int result = 1;
16    for (int i = 0; i < bSize; i++) {
17        // For each digit, exponentiate result by 10 and multiply by a^b[i]
18        result = modPow(result, 10, mod) * modPow(a, b[i], mod) % mod;
19    }
20    return result;
21}