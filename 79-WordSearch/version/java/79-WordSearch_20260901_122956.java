// Last updated: 01/09/2026, 12:29:56
1class Solution {
2    public int evalRPN(String[] tokens) {
3        Stack<Integer> stack = new Stack<>();
4
5        for (String token : tokens) {
6            if ("+-*/".contains(token) && token.length() == 1) {
7                int b = stack.pop();
8                int a = stack.pop();
9
10                if (token.equals("+"))
11                    stack.push(a + b);
12                else if (token.equals("-"))
13                    stack.push(a - b);
14                else if (token.equals("*"))
15                    stack.push(a * b);
16                else
17                    stack.push(a / b);
18            } else {
19                stack.push(Integer.parseInt(token));
20            }
21        }
22
23        return stack.pop();
24    }
25}