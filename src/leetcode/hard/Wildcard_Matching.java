package leetcode.hard;

public class Wildcard_Matching {
	/*
	 	44. Wildcard Matching
		Hard

		Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
		'?' Matches any single character.
		'*' Matches any sequence of characters (including the empty sequence).
		The matching should cover the entire input string (not partial).
		
		Example 1:
		Input: s = "aa", p = "a"
		Output: false
		Explanation: "a" does not match the entire string "aa".

		Example 2:
		Input: s = "aa", p = "*"
		Output: true
		Explanation: '*' matches any sequence.

		Example 3:
		Input: s = "cb", p = "?a"
		Output: false
		Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
		
		Constraints:
		0 <= s.length, p.length <= 2000
		s contains only lowercase English letters.
		p contains only lowercase English letters, '?' or '*'.
	 */
	public boolean isMatch(String s, String p) {
		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++)
			if (p.charAt(i) == '*')
				dp[0][i + 1] = dp[0][i];
		for (int i = 0; i < s.length(); i++)
			for (int j = 0; j < p.length(); j++) {
				if( p.charAt(j) == '*' )
					dp[i + 1][j + 1] = (dp[i][j + 1] | dp[i + 1][j] | dp[i][j]);
				else if( s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' )
					dp[i + 1][j + 1] = dp[i][j];
			}
		return dp[s.length()][p.length()];
    }
	//DP 동적계획법 
	public boolean isMatch1(String s, String p) {	    
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;

	    for(int i=1; i<=p.length(); i++) {
	        boolean flag = false; 

	        for(int j=0; j<=s.length(); j++) {
	            flag = flag || dp[i-1][j];
	            char c = p.charAt(i-1);
	            
	            if(c != '*') {
	                dp[i][j] = j>0 && dp[i-1][j-1] && (c=='?' || c==s.charAt(j-1));
	            }
	            else {
	                dp[i][j] = i==1 || flag;
	            }
	        }
	    }
	    
	    return dp[p.length()][s.length()];
    }
}