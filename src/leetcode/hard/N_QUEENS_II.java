package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class N_QUEENS_II {
	/*
		52. N-Queens II	(Hard)
		Companies
		The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
		Given an integer n, return the number of distinct solutions to the n-queens puzzle.
		
		Example 1:
		Input: n = 4
		Output: 2
		Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

		Example 2:
		Input: n = 1
		Output: 1
		
		Constraints:
		1 <= n <= 9
	 */
	int count =0;
	Set<Integer> cols = new HashSet<>();
	Set<Integer> diag1 = new HashSet<>();
	Set<Integer> diag2 = new HashSet<>();
	//기존 퀸의 위치를 배열로 출력하는 문제에서 유효한 값이 몇개인지를 출력하도록 변경
	public int totalNQueens(int n) {
		dfs(0,0,n);
		return count;
    }
	public void dfs(int row , int col, int len) {
		if(row==len) {
			count++;
			return;
		}
		if(col==len) {
			return;
		}
		if(isVaild(row , col)) {
			addVaild(col,row);
			dfs(row+1,0,len);
			
			removeVaild(col,row);
			dfs(row,col+1,len);
		}
		else dfs(row,col+1,len);
	}

	public boolean isVaild(int row , int col) {
		if(cols.contains(col) || diag1.contains(row-col) || diag2.contains(row+col)) return false;
		return true;
	}
	public void addVaild(int col, int row) {
		cols.add(col);
		diag1.add(row-col);
		diag2.add(row+col);
	}
	public void removeVaild(int col, int row) {
		cols.remove(col);
		diag1.remove(row-col);
		diag2.remove(row+col);
	}
}