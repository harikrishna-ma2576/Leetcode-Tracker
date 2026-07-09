// Last updated: 09/07/2026, 15:12:37
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        boolean[][] vis=new boolean[r][c];
        int ans=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!vis[i][j] && grid[i][j] == 1) {
                    int area = bfs(grid, vis, i, j);
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
    int bfs(int[][] grid, boolean[][] vis, int r, int c){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        vis[r][c]=true;
        int area=0;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            area++;
            for(int k=0;k<4;k++){
                int nr=x+dir[k][0];
                int nc=y+dir[k][1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]==1){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return area;
    }
      
        
    
}
