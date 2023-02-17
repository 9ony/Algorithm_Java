package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_PhoneNumber {
	/*
	 	17. Letter Combinations of a Phone Number
		Companies
		Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
		A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
		
		Example 1:
		Input: digits = "23"
		Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
		
		Image :
		ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		|    1				2				3	|
		|	( )			  a b c           d e f |
		|	 4				5				6   |
		|   ghi			  j k l			  m n o |
		|	 7				8				9   |
		|  pqrs			  t u v			  wxyz  |
		|	 *				0				#   |
		|	 +			  "   "				^   |
		ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		Example 2:
		Input: digits = ""
		Output: []

		Example 3:
		Input: digits = "2"
		Output: ["a","b","c"]
		
		Constraints:
		0 <= digits.length <= 4
		digits[i] is a digit in the range ['2', '9'].
	 */
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits.length()>4 && digits.length()<1) {
			return result;
		}else if (!digitscheck(digits)) {
			return result;
		}
		
		String[] keyPad= {"0","1","abc","def","ghi","jkl","mno","pgrs","tuv","wxyz","*","zero","#"};
		
		dfs(result,digits,"",0,keyPad);
		
		return result;
	}
	
	private boolean digitscheck(String digits) {
		for(int i = 0 ; i<digits.length(); i++) {
			if(!(digits.charAt(i)+0>=50 && digits.charAt(i)+0<=57)){
				return false;
			}
		}
		return true;
	}
	
	private void dfs(List<String> result , String digits , String curr , int idx , String[] KeyPad) {
		if (idx == digits.length()){
            result.add(curr);
            return;
        }
        String letter = KeyPad[digits.charAt(idx) - '0'];
        for (int i=0; i<letter.length(); i++){
            dfs(result, digits, curr + letter.charAt(i), idx+1, KeyPad);
        }
		
	}
	/*
	private String[] digitconverter(String digits) {
		String[] dc = new String[digits.length()];
		String[] keyPad= {"abc","def","ghi","jkl","mno","pgrs","tuv","wxyz"};
		for(int i = 0 ; i<digits.length(); i++) {
			int keyPadIdx = Integer.parseInt(digits.charAt(i)+"")-2;
			dc[i] = keyPad[keyPadIdx];
			System.out.println(keyPad[keyPadIdx]);
		}
		return dc;
	}
	*/
}
