
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows
        for (int r = 0; r < 9; r++) {
            Set<Character> seen = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (ch < '1' || ch > '9') return false;
                if (!seen.add(ch)) return false;
            }
        }

        // cols
        for (int c = 0; c < 9; c++) {
            Set<Character> seen = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (ch < '1' || ch > '9') return false;
                if (!seen.add(ch)) return false;
            }
        }

        // 3x3 boxes
        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {
                Set<Character> seen = new HashSet<>();
                for (int r = br * 3; r < br * 3 + 3; r++) {
                    for (int c = bc * 3; c < bc * 3 + 3; c++) {
                        char ch = board[r][c];
                        if (ch == '.') continue;
                        if (ch < '1' || ch > '9') return false;
                        if (!seen.add(ch)) return false;
                    }
                }
            }
        }

        return true;
    }
}



/*
1. Check every row
2. Check every column
3. Check every boxes -> 
mirror:
[0,0] -> [0,2] |[0,3] -> [0,5] |
[1,0] -> [1,2] |[1,3] -> [1,5] |
[2,0] -> [2,2] |[2,3] -> [2,5] |
----------------
[3,0] -> [3,2] |
[4,0] -> [1,2] |
[5,0] -> [2,2] |

9/3 = 8/3 -> 2
5/3 -> 1

2/ 3 -> 0
*/

