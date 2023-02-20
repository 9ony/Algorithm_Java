package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Valid_Parentheses {
	/*
	    20. Valid Parentheses
		Companies
		Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
		
		An input string is valid if:
		
		Open brackets must be closed by the same type of brackets.
		Open brackets must be closed in the correct order.
		Every close bracket has a corresponding open bracket of the same type.

		Example 1:
		Input: s = "()"
		Output: true

		Example 2:
		Input: s = "()[]{}"
		Output: true

		Example 3:
		Input: s = "(]"
		Output: false

		Constraints:
		1 <= s.length <= 104
		s consists of parentheses only '()[]{}'.
	 */
	public boolean isValid(String s) {
		//s 의길이가 2보다 작거나 홀수면 false 짝이안맞기때문에!
		if(s.length()<2 || s.length()%2==1) {
			return false;
		}
		List<Character> list = new ArrayList<>();
		for(int i = 0 ; i<s.length(); i++) {
			if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
				list.add(s.charAt(i));
			}else if (list.size()<1) {
				return false;
			}else {
				if(Math.abs((s.charAt(i)+0)-(list.get(list.size()-1)+0))<3){
					list.remove(list.size()-1);
				}else
					return false;
			}
			//System.out.println(list.toString());
		}
		return (list.isEmpty())? true : false;
    }
}
