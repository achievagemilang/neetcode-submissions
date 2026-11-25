class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int n = grid[i][j];
                if(grid[i][j] == '1'){
                    visit(i, j, grid);
                    count++;
                }
            }
        }        

        return count;
    }

    public void visit(int i, int j, char[][] grid){
        grid[i][j] = '0';

        int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] dir: dirs){
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            if(inBorder(nextI, nextJ, grid) && grid[nextI][nextJ] != '0'){
                visit(nextI, nextJ, grid);
            }
        }
    }

    public boolean inBorder(int i, int j, char[][] grid){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}

/**
Edge:
- if array is empty / null -> return 0

Idea is BFS
1. Keep count as return ans
2. Loop from top left [0, 0] find the first 1, visit it, then traverse until:
- out of border
- find 0  
- If finds 1, convert to 0
once it finished -> count++
3. loop through bottom right -> [n, m]
*/