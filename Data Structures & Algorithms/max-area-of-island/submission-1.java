class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int ans = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(visit(i, j, grid), ans);
                }
            }
        }

        return ans;
    }

    public int visit(int i, int j, int[][] grid){
        grid[i][j] = 0;
        int area = 1;

        int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        for(int[] d: dirs){
            int nextI = d[0] + i;
            int nextJ = d[1] + j;

            if(isInBorder(nextI, nextJ, grid) && grid[nextI][nextJ] == 1){
                area += visit(nextI, nextJ, grid);
            }    
        }

        return area;
    }

    public boolean isInBorder(int i, int j, int[][] grid){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}

/**
Idea is same like num of island, but instead we keep track maxCount when visiting an island

Loop from the top left [0, 0] -> bottom right [n, m]
if Find 1:
- we start traversing the island and increment the count, mark visited to 0 so we know we wouldn't need to visit it again
- traverse by going up, left, right, down 
- keep traversing if valid condition: isInBorder() && next visit node is not 0. If not, do not visit

Edge case:
- Null array or empty array
*/