// Last updated: 09/07/2026, 15:11:49
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] comp = dfs(i, graph, visited);

                int nodes = comp[0];
                int edgeCount = comp[1] / 2; // undirected graph counted twice

                if (edgeCount == (nodes * (nodes - 1)) / 2) {
                    result++;
                }
            }
        }

        return result;
    }

    private int[] dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;

        int nodes = 1;
        int edges = graph[node].size();

        for (int nei : graph[node]) {
            if (!visited[nei]) {
                int[] temp = dfs(nei, graph, visited);
                nodes += temp[0];
                edges += temp[1];
            }
        }

        return new int[]{nodes, edges};
    }
}