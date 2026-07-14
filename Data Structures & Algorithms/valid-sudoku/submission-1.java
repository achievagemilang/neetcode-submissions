/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            set = new HashSet<>();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])){
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }

        for (int j = 0; j < board[0].length; j++){
            set = new HashSet<>();
            for(int i = 0; i < board.length; i++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])){
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }

        HashMap<String, HashSet<Character>> map = new HashMap<>();
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                map.put(String.format("[%d, %d]", i, j), new HashSet<>());
            }
        }

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                int rBox = i / 3;
                int cBox = j / 3;

                HashSet<Character> subBoxSet = map.get(String.format("[%d, %d]", rBox, cBox));
                
                if(subBoxSet.contains(board[i][j])){
                    return false;
                } else {
                    subBoxSet.add(board[i][j]);
                }
            }
        }
        return true;
    }
}

/*
1. The idea is to actually check these straight forward:
- Check every row if there's any duplicate
- Check every column if there's any duplicate
- Check every subsquares is there's any duplicate
*/
// @lc code=end

