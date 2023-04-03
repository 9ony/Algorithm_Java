package leetcode.eazy;

import java.util.Arrays;

import common.ListNode;

public class Longest_Common_Prefix {
	/*
	 * 14. Longest Common Prefix
		Companies
		Write a function to find the longest common prefix string amongst an array of strings.
		If there is no common prefix, return an empty string "".
		
		Example 1:
		Input: strs = ["flower","flow","flight"]
		Output: "fl"

		Example 2:
		Input: strs = ["dog","racecar","car"]
		Output: ""

		Explanation: There is no common prefix among the input strings.

		Constraints:
		1 <= strs.length <= 200
		0 <= strs[i].length <= 200
		strs[i] consists of only lowercase English letters.
	 */
	public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
	public String longestCommonPrefix2(String[] strs) {
		Arrays.sort(strs);
		//print strs start
		System.out.println("===Print Strs====");
		for(int i = 0; i<strs.length;i++) {
			System.out.println(strs[i]);
		}
		System.out.println("=================");
		//prints strs end
	    String s1 = strs[0];
	    String s2 = strs[strs.length-1];
	    int idx = 0;
	    Integer start = null;
	    while(idx < s1.length() && idx < s2.length()){
	    	if(start==null) {
		    	if(s1.charAt(idx) == s2.charAt(idx)){
		        	start = idx;
		        }else {
		        	idx++;
		        }
	    	}else {
	    		if(s1.charAt(idx)== s2.charAt(idx)) {
		    		idx++;
		    	}else{
		    		break;
		    	}
	    	}
	    }
	    //System.out.println(start);
	    return (start==null) ? "" : s1.substring(start, idx);
	}
}