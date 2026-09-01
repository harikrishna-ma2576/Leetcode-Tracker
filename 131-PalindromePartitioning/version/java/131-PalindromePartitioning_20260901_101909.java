// Last updated: 01/09/2026, 10:19:09
1class Solution {
2    public List<List<String>> partition(String s) {
3        List<List<String>> res = new ArrayList<>(); // which will be our answer
4        List<String> path = new ArrayList<>(); // as we are generating list everythime, so at the end this will be our list
5        helper(0, s, path, res); // calling to recursion function start from index 0 and string s
6        return res;
7    }
8    // Entire recursive function, that generates all the partition substring
9    public void helper(int index, String s, List<String> path, List<List<String>> res){
10        // Base Condition, which means when we have done partition at the end (n), then add it to our ultimate result
11        if(index == s.length()){
12            res.add(new ArrayList<>(path));
13            return;
14        }
15        // Let's talk about partition
16        for(int i = index; i < s.length(); i++){
17            if(isPalindrome(s, index, i)){ // what we are checking over here is, if we partition the string from index to i Example-(0, 0) is palindrome or not
18                path.add(s.substring(index, i + 1)); // take the substring and store it in our list & call the next substring from index + 1
19                helper(i + 1, s, path, res); // as we have done for (0, 0) then our next will be from (1)
20                path.remove(path.size() - 1); // please make sure you remove when you backtrack. 
21                // Why? Because let say i had partion y, so when i go back. I can't have yy
22            }
23        }
24    } 
25    
26    public boolean isPalindrome(String s, int start, int end){ // A simple palindromic function start from 0 go till end. And basically keep on checking till they don't cross. 
27        while(start <= end){
28            if(s.charAt(start++) != s.charAt(end--)) return false;
29        }
30        return true;
31    }
32}