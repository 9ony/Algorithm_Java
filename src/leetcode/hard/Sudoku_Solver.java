package leetcode.hard;

import java.util.Arrays;

public class Sudoku_Solver {
	/*
		37. Sudoku Solver
		Companies
		Write a program to solve a Sudoku puzzle by filling the empty cells.
		A sudoku solution must satisfy all of the following rules:
		
		Each of the digits 1-9 must occur exactly once in each row.
		Each of the digits 1-9 must occur exactly once in each column.
		Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
		The '.' character indicates empty cells.
		
		Example 1:
		Input: board = [
		["5","3",".",".","7",".",".",".","."],
		["6",".",".","1","9","5",".",".","."],
		[".","9","8",".",".",".",".","6","."],
		["8",".",".",".","6",".",".",".","3"],
		["4",".",".","8",".","3",".",".","1"],
		["7",".",".",".","2",".",".",".","6"],
		[".","6",".",".",".",".","2","8","."],
		[".",".",".","4","1","9",".",".","5"],
		[".",".",".",".","8",".",".","7","9"]
		]
		Output: [
		["5","3","4","6","7","8","9","1","2"],
		["6","7","2","1","9","5","3","4","8"],
		["1","9","8","3","4","2","5","6","7"],
		["8","5","9","7","6","1","4","2","3"],
		["4","2","6","8","5","3","7","9","1"],
		["7","1","3","9","2","4","8","5","6"],
		["9","6","1","5","3","7","2","8","4"],
		["2","8","7","4","1","9","6","3","5"],
		["3","4","5","2","8","6","1","7","9"]
		]
		Explanation: The input board is shown above and the only valid solution is shown below:
		
		Constraints:
		board.length == 9
		board[i].length == 9
		board[i][j] is a digit or '.'.
		It is guaranteed that the input board has only one solution.
	 */
	//Depth First Search(DFS) 8ms 
	public void solveSudoku(char[][] board) {
        dfs(board,0);
        
        //print sudoku
        for(int i=0; i<9 ; i++) {
        	for(int j=0; j<9;j++) {
        		System.out.print(board[i][j]+" ");
        	}
        	System.out.println("");
        }
        
	}
    private boolean dfs(char[][] board, int d) {
        if (d==81) return true;
        int i=d/9, j=d%9; //i는 행(9로나눈 몫) , j는 열 (9로나눈 나머지)
        // '.'일 경우 Skip
        if (board[i][j]!='.') return dfs(board,d+1); //.이 아닌 숫자라면 다음칸으로 이동
        
        boolean[] flag=new boolean[10];
        validate(board,i,j,flag);
        for (int k=1; k<=9; k++) {
            if (flag[k]) {
            	System.out.println("d=>"+d+"   k=>"+k);
                board[i][j]=(char)('0'+k);
                if (dfs(board,d+1)) return true;
            }
        }
        board[i][j]='.';
        return false;
    }
    //검증하는 메서드
    private void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag,true);
        //flag를 다 true로 채운후 
        //파라미터로 들어온 i와 j값에서 
        //1. i(행)에 해당되는 열 k값이 .이아닐때 board[i][k] 값을 false로 설정 
        //2. k(행)에 해당되는 열 j값이 .이아닐때 board[k][j] 값을 false로 설정
        //3. i,j를 포함하는 3x3 블럭안에 포함되는 숫자들을 false;
        //즉 위에 조건에 해당되는 값들은 전부 false로 설정하고 나머지 숫자들은 true로 유지되어 숫자가 필터링된다.
        for (int k=0; k<9; k++) {
            if (board[i][k]!='.') flag[board[i][k]-'0']=false;
            if (board[k][j]!='.') flag[board[k][j]-'0']=false;
            int r=i/3*3+k/3;
            int c=j/3*3+k%3;
            if (board[r][c]!='.') flag[board[r][c]-'0']=false;
        }
    }
    /*
		Depth First Search(DFS)를 사용
		가능한 모든 경우를 탐색하면서 유효한 숫자를 채움
		스도쿠 판은 9x9 크기이며, 각 칸에는 숫자 또는 '.'이 들어감.
		'.'은 아직 채워지지 않은 숫자.
		dfs 함수는 현재 탐색 중인 칸의 인덱스 d와 스도쿠 판 board를 인자로 받음.
		d가 81이 되면 스도쿠가 해결된 것이므로 true를 반환.
		그렇지 않으면, i와 j를 d를 이용하여 계산합니다.(i는 d를 9로 나눈 몫, j는 d를 9로 나눈 나머지)
		현재 탐색 중인 칸의 값이 '.'이 아니면, 다음 칸으로 이동합니다.
		그렇지 않으면, 현재 칸에 들어갈 수 있는 숫자를 검증함. 이를 위해 validate 함수를 호출함
		validate 함수는 board, i, j, flag를 인자로 받음.
		flag는 0부터 9까지의 숫자가 유효한지를 나타내는 배열.
		1.모든 숫자는 일단 true로 초기화됩니다.
		2. 3가지 경우를 검증합니다.
		 - i번째 행에 있는 열 k에서 board[i][k]의 값이 '.'이 아니면, flag[board[i][k]-'0']를 false로 설정합니다. 이는 해당 숫자가 이미 존재하기 때문에 다시 사용할 수 없기 때문입니다.
		 - k번째 열에 있는 행 j에서 board[k][j]의 값이 '.'이 아니면, flag[board[k][j]-'0']를 false로 설정합니다.
		 - i,j를 포함하는 3x3 블록안에 포함되는 숫자들을 검증합니다. 이를 위해 r과 c를 계산합니다.
		   r은 i를 3으로 나눈 몫에 3을 곱하고, k를 3으로 나눈 몫을 더합니다.
		   c는 j를 3으로 나눈 몫에 k를 3으로 나눈 나머지를 더합니다.
		이때, board[r][c]의 값이 '.'이 아니면, flag[board[r][c]-'0']를 false로 설정합니다.
		이렇게 검증된 flag를 바탕으로, 1부터 9까지의 숫자 중에서 가능한 숫자를 찾습니다. 가능한 숫자가 없으면 false를 반환합니다.
		가능한 숫자가 있으면, 해당 숫자를 board[i][j]에 채우고, dfs 함수를 다시 호출합니다.
		이때, d+1을 인자로 전달하여 다음 칸을 탐색하도록 합니다. 만약 dfs 함수가 true를 반환하면, 스도쿠가 해결된 것이므로 true를 반환합니다.
		가능한 숫자가 없으면, 다시 '.'으로 바꾸고 이전 상태로 돌아갑니다. 이를 위해 backtracking을 사용합니다.
		이렇게 모든 경우를 탐색하면서 유효한 숫자를 채워나가면, 스도쿠가 해결됩니다.
     */
    
    
    //1ms code (참고) bit masking 사용
    //
    private final static int SIZE = 9;
    private final static int BLOCK_SIZE = 3;
    private final static char EMPTY_CELL = '.';
    private final static int allBits = 0x1ff;
    private final static int[] bitFlags = new int[]{
            0x1,
            0x1 << 1,
            0x1 << 2,
            0x1 << 3,
            0x1 << 4,
            0x1 << 5,
            0x1 << 6,
            0x1 << 7,
            0x1 << 8,
    };

    private char[][] board;
    private int[] rows;
    private int[] cols;
    private int[] blocks;
    private int totalCount = 0;

    public void solveSudoku2(char[][] board) {
        if (board == null || board.length != SIZE && board[0].length != SIZE) throw new IllegalArgumentException();
        this.board = board;
        initialize();
        initialUpdate();
        bruteForce();
    }

    private void initialize() {
        rows = new int[SIZE];
        cols = new int[SIZE];
        blocks = new int[SIZE];
        totalCount = 0;
    }

    private boolean bruteForce() {
        if (totalCount >= SIZE * SIZE) return true;
        int row = -1;
        int col = -1;

        int min = SIZE + 1;
        for (int r = 0; r < SIZE && min > 1; ++r) {
            for (int c = 0; c < SIZE; ++c) {
                if (board[r][c] != EMPTY_CELL) continue;
                int candidateCounts = getCandidateCount(r, c);
                if (candidateCounts < min) {
                    min = candidateCounts;
                    row = r;
                    col = c;
                }
                if (min == 1) break;
            }
        }
        if (min < 1) return false;
        int candidates = getCandidates(row, col);

        for (int i = 0; i < SIZE && candidates != 0; ++i, candidates >>= 1) {
            if (candidates % 2 == 0) continue;
            mark(i, row, col);
            board[row][col] = toChar(i);
            if (bruteForce()) return true;
            board[row][col] = EMPTY_CELL;
            unmark(i, row, col);
        }
        return false;
    }

    private int getCandidates(int row, int col) {
        int blkId = row / BLOCK_SIZE * BLOCK_SIZE + col / BLOCK_SIZE;
        return ~(rows[row] | cols[col] | blocks[blkId]) & allBits;
    }

    private int getCandidateCount(int row, int col) {
        int candidates = getCandidates(row, col);
        int count = 0;
        for (int i = 0; candidates != 0; ++i, candidates = candidates & (candidates - 1)) ++count;
        return count;
    }

    private void mark(int value, int row, int col) {
        int blkId = row / BLOCK_SIZE * BLOCK_SIZE + col / BLOCK_SIZE;
        int flag = bitFlags[value];
        rows[row] |= flag;
        cols[col] |= flag;
        blocks[blkId] |= flag;
        ++totalCount;
    }

    private void unmark(int value, int row, int col) {
        int blkId = row / BLOCK_SIZE * BLOCK_SIZE + col / BLOCK_SIZE;
        int mask = ~bitFlags[value];
        rows[row] &= mask;
        cols[col] &= mask;
        blocks[blkId] &= mask;
        --totalCount;
    }

    private void initialUpdate() {
        for (int r = 0; r < SIZE; ++r) {
            for (int c = 0; c < SIZE; ++c) {
                if (board[r][c] == EMPTY_CELL) continue;
                int value = fromChar(board[r][c]);
                mark(value, r, c);
            }
        }
    }

    private static int fromChar(char c) {
        return c - '1';
    }

    private static char toChar(int i) {
        return (char) (i + '1');
    }
}
