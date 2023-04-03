package leetcode.medium;

public class Longest_Palindromic_Substring {
	/*
	 	5. Longest Palindromic Substring
	    Given a string s, return the longest palindromic substring in s.
		
		Example 1:
		Input: s = "babad"
		Output: "bab"
		Explanation: "aba" is also a valid answer.
		
		Example 2:
		Input: s = "cbbd"
		Output: "bb"
		 
		Constraints:
		1 <= s.length <= 1000
		s consist of only digits and English letters.
	 */
	public String longestPalindrome(String s) {
        if (s.length()<1 || s.length()>1000) return "문자열 크기가 1보다 크거나 1000보다 작아야합니다.";
		
        String result = null;
        int i = 1; 
        int max = 0;
        int end = s.length();
        int start = 0;
        
        
        while (start<end) {
        	if(i>=end) {
        		start++;
        		i = start+1;
        	}
        	try {
	        	if(s.charAt(start)==s.charAt(i) && (i+1-start)>max) {
	        		max = i+1-start;
	        		result = s.substring(start, i+1);
	        		if(s.charAt(i-1)!=s.charAt(i)) {
	        			start = i;
	        		}
	        	}
        	}catch(Exception e) {
        		continue;
        	}
        	i++;
        }
        return result = (result != null ) ? result : s.charAt(0)+"";
    }
	public String longestPalindrome2(String s) {
		int max = 1;
		String temp="";
		boolean check = true;
		int mid =1; //중심값
		int slen=s.length();
		if(s.length()<=2) {
			//파라미터로 들어온 문자열길이가 2 이하 일때 1이면 s그대로를 반환하고 2일때는 두개의문자가 같으면 s 아니면 첫번째문자를 반환  
			return temp = (s.length()==1) ? s : (s.length()==2 && s.charAt(0)==s.charAt(1)) ? s : s.charAt(0)+"" ;  
		}
		while(mid<slen-(max/2)) {
			int left = mid , right= mid;
			//while(left>=0&&s.charAt(left)==s.charAt(right)&&right<slen) {
			while(left>=0&&right<slen) {
				if(s.charAt(left)==s.charAt(right)) {
					if(max < s.substring(left,right+1).length()) { 
						//max값이 현재 대칭된문자열길이보다 작을경우에 해당 문자열길이와 문자열을 저장
						temp = s.substring(left, right+1);
						max = temp.length();
					}
					if(check&&s.charAt(mid)!=s.charAt(left)&&s.charAt(mid)!=s.charAt(right)) {
						check = false;
					}
				}else if(check && max<s.substring(left,right+1).length()) {
					temp = (s.charAt(mid)==s.charAt(right)) ? s.substring(left+1, right+1) : s.substring(left, right) ;
					max = temp.length();
				}
				left--;
				right++;
			}
			mid++;
		}
		return temp;
	}
	public String longestPalindrome3(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int l = -1, r = -1, maxLen = 0;
        // l is left value , r is right value
        //g is middle value
        
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) 
                	dp[i][j] = true;
                else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else { // g>1
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }
	public String longestPalindrome4(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
