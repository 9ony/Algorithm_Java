package leetcode.eazy;

public class Palindrome_Number {
	/*
	 	// 9. Palindrome_Number (eazy)
	 	 * 
		Given an integer x, return true if x is a palindrome , and false otherwise.

		Example 1:
		Input: x = 121
		Output: true
		Explanation: 121 reads as 121 from left to right and from right to left.
	
		Example 2:
		Input: x = -121
		Output: false
		Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
		
		Example 3:
		Input: x = 10
		Output: false
		Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
		 
		Constraints:
		-231 <= x <= 231 - 1
	*/	
	public boolean isPalindrome(int x) {
		if(Integer.MAX_VALUE<x&&0>x) {
			//음수도 false
			return false;
		}
		int tempx = x;
		int j=0;
		while(tempx>0) {
			j = j*10 + tempx % 10;
			tempx/=10;
		}
        return x==j;
    }
	public boolean isPalindrome2(int x) {
		if(Integer.MAX_VALUE<x&&0>x) {
			//음수도 false
			return false;
		}
		int i=(x+"").length()-1;
		int j=0;
		while(j<i) {
			if((x+"").charAt(i)!=(x+"").charAt(j)) {
				return false;
			}
			j++;
			i--;
		}
        return true;
    }
}
