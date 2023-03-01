package leetcode;

public class Find_the_Index_of_the_First_Occurrence_in_a_String {
	/*
	  	28. Find the Index of the First Occurrence in a String
		Companies
		Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
		
		Example 1:
		Input: haystack = "sadbutsad", needle = "sad"
		Output: 0
		Explanation: "sad" occurs at index 0 and 6.
		The first occurrence is at index 0, so we return 0.

		Example 2:
		Input: haystack = "leetcode", needle = "leeto"
		Output: -1
		Explanation: "leeto" did not occur in "leetcode", so we return -1.
		 
		Constraints:
		1 <= haystack.length, needle.length <= 104
		haystack and needle consist of only lowercase English characters.
	 */
	public int strStr(String haystack, String needle) {
        int duplicated=0;
        if(haystack.length() < needle.length()) return -1;
        while(duplicated <= haystack.length()-needle.length()) {
        	if(haystack.charAt(duplicated)==needle.charAt(0)) {
                int index = 0 ;
		        while(index < needle.length()) {
		        	if(haystack.charAt(index+duplicated)!=needle.charAt(index)) {
		        		break;
		        	}
		        	index++;
                    if(index==needle.length()) return duplicated;
		        }
        	}
	        duplicated++;
        }
        
		return -1;
    }
}
