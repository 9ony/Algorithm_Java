package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
	/*
	  	22. Generate Parentheses
		Companies
		Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
		
		Example 1:
		Input: n = 3
		Output: ["((()))","(()())","(())()","()(())","()()()"]

		Example 2:
		Input: n = 1
		Output: ["()"]
		
		Constraints:
		1 <= n <= 8
	 */
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String p = "";
        addParenthesis(result , p , n , 0);
		return result;
    }
	public void addParenthesis(List<String> result , String p , int n , int count) {
		//System.out.println("param==>"+"{"+"result : "+result+" , "+"p :"+ p+" , "+"n :"+n+" , "+"count :"+count+"}");
		if(n==0 && count==0) {
			result.add(p);
			return;
		}
		if(n>0) {
			addParenthesis(result,p+"(",n-1,count+1);
		}
		if (count>0) {
			addParenthesis(result,p+")",n,count-1);
		}
	}
}
