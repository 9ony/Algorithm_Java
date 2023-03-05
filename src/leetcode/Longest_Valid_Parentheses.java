package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Longest_Valid_Parentheses {
	/*
	 	32. Longest Valid Parentheses
		Companies
		Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
		substring
		
		Example 1:
		Input: s = "(()"
		Output: 2
		Explanation: The longest valid parentheses substring is "()".
	
		Example 2:
		Input: s = ")()())"
		Output: 4
		Explanation: The longest valid parentheses substring is "()()".

		Example 3:
		Input: s = ""
		Output: 0
		
		Constraints:
		0 <= s.length <= 3 * 104
		s[i] is '(', or ')'.
	 */
	public int longestValidParentheses(String s) {
		if(s.length()<2) return 0;
		
		List<Integer> arr = new ArrayList<>();
		arr.add(-1);
		int result = 0;
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				arr.add(i); // s 문자열의 i번째가 ( 일때 i값을 arr에 추가한다.
				System.out.println("if => "+arr);
			}
			else {
				arr.remove(arr.size()-1); //제일최근에 들어간 index값 삭제
				if(arr.isEmpty()) {
					arr.add(i);
				}else {
					result = Math.max(result, i - arr.get(arr.size()-1));
				}
				System.out.println("else => "+arr);
			}
		}
		return result;
    }
	//public boolean check(List<Character> arr,int i , int j) {
	//	
	//}
}
