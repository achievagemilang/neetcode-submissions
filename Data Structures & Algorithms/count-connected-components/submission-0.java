class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> adj = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        for(int i=0; i<n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                dfs(i);
                ans++;
            }
        }

        return ans;
    }

    public void dfs(int from){
        if(visited.contains(from)) return;

        visited.add(from);
        for(int to: adj.get(from)){
            dfs(to);
        }
    }
}
