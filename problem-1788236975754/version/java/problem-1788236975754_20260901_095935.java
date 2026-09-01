// Last updated: 01/09/2026, 09:59:35
1class Solution {
2    public List<List<Integer>> generate(int numRows) {
3        List<List<Integer>> list= new ArrayList<>();
4        
5        for(int i=0;i<numRows; i++){
6            List<Integer> temp=new ArrayList<>();
7            for(int k=0;k<i+1; k++){
8                temp.add(1);
9            }
10            for(int j=1; j<i;j++){
11                temp.set(j, list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
12            }
13            list.add(temp);
14        }
15        return list;
16    }
17}