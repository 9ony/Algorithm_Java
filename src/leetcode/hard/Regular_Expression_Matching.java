package leetcode.hard;

public class Regular_Expression_Matching {
	/*
	//10. Regular Expression Matching   (Hard)
	
	 Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

	'.' Matches any single character.​​​​
	'*' Matches zero or more of the preceding element.
	The matching should cover the entire input string (not partial).
	
	 
	
	Example 1:	
	Input: s = "aa", p = "a"
	Output: false
	Explanation: "a" does not match the entire string "aa".
	
	Example 2:	
	Input: s = "aa", p = "a*"
	Output: true
	Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

	Example 3:
	Input: s = "ab", p = ".*"
	Output: true
	Explanation: ".*" means "zero or more (*) of any character (.)".
	
	Constraints:
	1 <= s.length <= 20
	1 <= p.length <= 20
	s contains only lowercase English letters.
	p contains only lowercase English letters, '.', and '*'.
	It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
	*/
	/*
	 	s ="mississippi"
		p ="mis*is*p*."
	 */
	//DP(Dynamic Programming) example
	public boolean isMatch(String s, String p) {
		if(s.length()<1&&s.length()<=20&&p.length()<1&&p.length()<=20) {
			return false;
		}
		boolean memozation[][] = new boolean[s.length()+1][p.length()+1];
		memozation[0][0]=true;
		
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='*' && memozation[0][i-1]) {
				memozation[0][i+1] = true;
			}
		}
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<p.length();j++) {
				if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.') {
					memozation[i+1][j+1]=memozation[i][j];
				}
				else if (p.charAt(j)=='*') {
					if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
						memozation[i+1][j+1] = memozation[i+1][j-1];
	                } else {
	                	memozation[i+1][j+1] = (memozation[i+1][j] || memozation[i][j+1] || memozation[i+1][j-1]);
	                }
				}
			}
		}
		//System.out.println(memozation[0][0]);
		return memozation[s.length()][p.length()];
    }
	
	//Recursion Code
	public boolean isMatch2(String s, String p) {
	    if (p.length() == 0) {
	        return s.length() == 0;
	    }
	    if (p.length() > 1 && p.charAt(1) == '*') {  // second char is '*'
	        if (isMatch2(s, p.substring(2))) {
	            return true;
	        }
	        if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
	            return isMatch2(s.substring(1), p);
	        }
	        return false;
	    } else {                                     // second char is not '*'
	        if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
	            return isMatch2(s.substring(1), p.substring(1));
	        }
	        return false;
	    }
	}
	
	//1ms code 참고
	public boolean isMatch3(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        Boolean[][] memo = new Boolean[m + 1][n + 1];
        
        return dfs(s, 0, p, 0, memo);
    }
    
    private boolean dfs(String s, int i, String p, int j, Boolean[][] memo) {
        // base case
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (j == p.length()) {
            return false;
        }
        
        // check current letter
        boolean match = false;
        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            match = true;
        }
        
        // have '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean star = false;
            
            if ((match && dfs(s, i + 1, p, j, memo)) || dfs(s, i, p, j + 2, memo)) {
                star = true;
            }
            
            return memo[i][j] = star;
        }
        
        // no *
        if (match) {
            return memo[i][j] = dfs(s, i + 1, p, j + 1, memo);
        }
        
        return memo[i][j] = false;
    }
}
