package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Valid_Sudoku {
	/*
		36. Valid Sudoku
		Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
		Each row must contain the digits 1-9 without repetition.
		Each column must contain the digits 1-9 without repetition.
		Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

		Note:
		A Sudoku board (partially filled) could be valid but is not necessarily solvable.
		Only the filled cells need to be validated according to the mentioned rules.
		
		Example 1:
		Input: board = 
		[["5","3",".",".","7",".",".",".","."]
		,["6",".",".","1","9","5",".",".","."]
		,[".","9","8",".",".",".",".","6","."]
		,["8",".",".",".","6",".",".",".","3"]
		,["4",".",".","8",".","3",".",".","1"]
		,["7",".",".",".","2",".",".",".","6"]
		,[".","6",".",".",".",".","2","8","."]
		,[".",".",".","4","1","9",".",".","5"]
		,[".",".",".",".","8",".",".","7","9"]]
		Output: true
		Example 2:
		Input: board = 
		[["8","3",".",".","7",".",".",".","."]
		,["6",".",".","1","9","5",".",".","."]
		,[".","9","8",".",".",".",".","6","."]
		,["8",".",".",".","6",".",".",".","3"]
		,["4",".",".","8",".","3",".",".","1"]
		,["7",".",".",".","2",".",".",".","6"]
		,[".","6",".",".",".",".","2","8","."]
		,[".",".",".","4","1","9",".",".","5"]
		,[".",".",".",".","8",".",".","7","9"]]
		Output: false
		Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
		Since there are two 8's in the top left 3x3 sub-box, it is invalid.
		 
		Constraints:
		board.length == 9
		board[i].length == 9
		board[i][j] is a digit 1-9 or '.'.
	 */
	//내가작성한것 2ms
	public boolean isValidSudoku(char[][] board) {
		List<Character> IntCheck = new ArrayList<>();
		
		// 1. Each row must contain the digits 1-9 without repetition.
		for(int i = 0 ; i<board[0].length; i++) {
			for(int j = 0 ; j<board[i].length; j++) {
				if(board[j][i]-'0'>0 && board[j][i]-'0'<10) {
					if(IntCheck.contains(board[j][i])) return false;
					IntCheck.add(board[j][i]);
				}
			}
			IntCheck.clear();
		}
		
		//2. Each column must contain the digits 1-9 without repetition.
		for(int i = 0 ; i<board[0].length; i++) {
			for(int j = 0 ; j<board[i].length; j++) {
				if(board[i][j]-'0'>0 && board[i][j]-'0'<10) {
					if(IntCheck.contains(board[i][j])) return false;
					IntCheck.add(board[i][j]);
				}
			}
			IntCheck.clear();
		}
		
		//3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
		int k = 1;
		while(k<4) {
			int l=1;
			while(l<4) {
				for(int i = 3*k-3 ; i< k*3; i++) {
					for(int j = 3*l-3; j< l*3; j++) {
						System.out.println(i+","+j);
						if(board[i][j]-'0'>0 && board[i][j]-'0'<10) {
							if(IntCheck.contains(board[i][j])) return false;
							IntCheck.add(board[i][j]);
						}
					}
				}
				l++;
			}
			k++;
		}
		
		return true;
    }
	//참고코드 1ms
	//참고한 코드를 살펴보면 
	//board를 순차적으로 9*9번 반복하면서 해당인덱스가 .이면 continue를
	//아니면 isValid 메서드를 실행하는데 해당 col과 row 열과 행을 체크해서 같은수가 있는지 체크하고
	//또 파라미터로넘어간 row col 값에 해당되는 3x3박스 범위를 탐색하여 중복값들을 체크한다.
	public boolean isValidSudoku2(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                if (!isValid(board, row, col)) return false;
            }
        }
        
        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        char value = board[row][col];

        for (int i = 0; i < 9; i++) {
            // check value horizontally
            if (board[row][i] == value && col != i) return false;
            // check value vertically
            if (board[i][col] == value && row != i) return false;
        }

        // check value is valid for current sub-block
        int startX = col / 3 * 3;
        int startY = row / 3 * 3;

        for (int y = startY; y < startY + 3; y++) {
            for (int x = startX; x < startX + 3; x++) {
                if (board[y][x] == value && y != row && x != col) {
                    return false;
                }
            }
        }


        return true;
    }
}
