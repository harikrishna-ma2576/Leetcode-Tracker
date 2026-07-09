// Last updated: 09/07/2026, 15:13:15
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, isConnected, visited);
            }
        }

        return count;
    }

    public void bfs(int start, int[][] isConnected, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int city = q.poll();

            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[city][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    q.offer(j);
                }
            }
        }
    }
}
