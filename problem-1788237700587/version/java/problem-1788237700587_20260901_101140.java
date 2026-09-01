// Last updated: 01/09/2026, 10:11:40
1class Solution {
2    public void solve(char[][] board) {
3        boolean vis[][] = new boolean [board.length][board[0].length];
4       
5       Queue<int[]> qu = new LinkedList<>();
6       
7       for(int i =0;i< board.length;i++){
8           for(int j =0;j< board[0].length;j++){
9               if(i==0||j==0||i==board.length-1||j==board[0].length-1){
10                   if(board[i][j]=='O'){
11                       vis[i][j]=true;
12                       qu.add(new int[]{i,j});
13                   }
14               }
15           }
16       }
17       while(!qu.isEmpty()){
18           int arr[]= qu.poll();
19           int r = arr[0];
20           int c =arr[1];
21         
22           if(r-1>=0&&!vis[r-1][c]&&board[r-1][c]=='O'){
23               vis[r-1][c]=true;
24               qu.add(new int []{r-1,c});
25           }
26           if(c-1>=0&&!vis[r][c-1]&&board[r][c-1]=='O'){
27               vis[r][c-1]=true;
28               qu.add(new int []{r,c-1});
29           }
30           
31           if(r+1<board.length&&!vis[r+1][c]&&board[r+1][c]=='O'){
32               vis[r+1][c]=true;
33               qu.add(new int []{r+1,c});
34           }
35
36           if(c+1<board[0].length&&!vis[r][c+1]&&board[r][c+1]=='O'){
37               vis[r][c+1]=true;
38               qu.add(new int []{r,c+1});
39           }           
40       }
41       for(int i =0;i<board.length;i++){
42           for(int j = 0 ;j< board[0].length;j++){
43               if(!vis[i][j]){
44                   board[i][j]='X';
45               }else{
46                   board[i][j]='O';
47               }
48           }
49       }
50        
51    }
52}