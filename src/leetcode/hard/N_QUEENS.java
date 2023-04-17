package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N_QUEENS {
	/*
	 * 51. N-Queens	(Hard)
		The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
		Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
		Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
		
		Example 1:
		Input: n = 4
		Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

		Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
		Example 2:
		Input: n = 1
		Output: [["Q"]]
		
		Constraints:
		1 <= n <= 9
	 */
	List<List<String>> result = new ArrayList<>();
	Set<Integer> cols = new HashSet<>(); //column에 퀸이 있는지 체크용 Set
	Set<Integer> diag1 = new HashSet<>();// row-col 왼쪽위에서 오른쪽아래 체크 
	Set<Integer> diag2 = new HashSet<>();// row+col 왼쪽아래서 오른쪽위를 체크
	public List<List<String>> solveNQueens(int n) {
		dfs(0,0,n,new ArrayList<>());
		return result;
    }
	//N-Queens II (hard) 결과 배열크기출력
	public int solveNQueensII(int n) {
		dfs(0,0,n,new ArrayList<>());
		return result.size();
	}
	public void dfs(int row , int col, int len,ArrayList<String> board) {
		if(row==len) {
			//row값이 len(파라미터로들어온 n) 값과 일치하면 board4개가 성공적으로 써졋단 뜻이므로 result에 add해준다.
			result.add(new ArrayList<String>(board)); 
			return ;
		}
		if(col==len) {
			return; //isVaild가 계속 false로 나왔다는 의미 col이 len까지 증가했으면 return;
		}
		if(isVaild(row , col)) {
			board.add(rowStr(col,len));
			addVaild(col,row);
			dfs(row+1,0,len,board);
			
			board.remove(board.size()-1);
			removeVaild(col,row);
//			dfs(row,col+1,len,board);
			
		}
//		else dfs(row,col+1,len,board);
		dfs(row,col+1,len,board);
	}
	// row에 들어갈 문자열 생성메서드
	public String rowStr(int col,int len) {
		StringBuffer rowStr = new StringBuffer();
		for(int i=0; i<len;i++) {
			if(i==col) rowStr.append("Q");
			else rowStr.append(".");
		}
		return rowStr.toString();
	}
	//유효한지 검사하는 메서드
	public boolean isVaild(int row , int col) {
		//cols , diag1 , diag2에 중복된값이 있으면 false를 반환
		if(cols.contains(col) || diag1.contains(row-col) || diag2.contains(row+col)) return false;
		return true;
	}
	
	//cols , diag1 ,diag2 값 추가
	public void addVaild(int col, int row) {
		cols.add(col);
		diag1.add(row-col);
		diag2.add(row+col);
	}
	//cols , diag1 ,diag2 값 삭제
	public void removeVaild(int col, int row) {
		cols.remove(col);
		diag1.remove(row-col);
		diag2.remove(row+col);
	}
}
