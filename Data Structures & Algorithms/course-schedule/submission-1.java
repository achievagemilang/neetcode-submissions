class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        for(int[] pair: prerequisites){
            List<Integer> val = adj.getOrDefault(pair[0], new ArrayList<>());
            val.add(pair[1]);
            adj.put(pair[0], val);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(i, visited, adj)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int n, Set<Integer> visited, Map<Integer, List<Integer>> adj){
        if(visited.contains(n)) return false;
        List<Integer> pres = adj.get(n);
        if(pres.isEmpty()) return true;
        
        visited.add(n);
        for(int pre: adj.get(n)){
            if(!dfs(pre, visited, adj)){
                return false;
            }
        }

        visited.remove(n);
        return true;

    }
}
