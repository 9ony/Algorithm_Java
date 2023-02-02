package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {
	/*
	 	3. Longest Substring Without Repeating Characters (medium)
	 	link:https://leetcode.com/problems/longest-substring-without-repeating-characters/
	  	Given a string s, find the length of the longest 
		substring
		 without repeating characters.
	
		Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
		
		Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		
		Example 3:
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		 
		Constraints:
		0 <= s.length <= 5 * 104
		s consists of English letters, digits, symbols and spaces.
	*/
	public int lengthOfLongestSubstring(String s) {
		int max=0;
		Set<Character> sArr = new HashSet<>();
		//List<Character> resultArr = null;
		//System.out.println("input String length===>"+s.length());
		
		for(int i =0; i<s.length(); i++) {
			if(sArr.contains(s.charAt(i))) { //sArr에 중복된 문자가 들어오면
				//System.out.println("for문 i값 ==>"+i);
				sArr.clear(); //sArr을 삭제
				char nowchar = s.charAt(i);
				//System.out.println("nowchar==>"+nowchar + "\ni값==>"+ i);

				for(int j=--i; j==0; j--)
				{
                    if(nowchar==s.charAt(j)) {
                    	i=++j;
                    	break;
                    }
                }
			}
			//System.out.println("변경된 i값==>"+i);
			sArr.add(s.charAt(i));
			//System.out.println(sArr.toString()+"/"+sArr.size());
			if(max<=sArr.size()){
				max=sArr.size();
				//resultArr = new ArrayList<>(sArr);
			}
		}
		
		//System.out.println("sArr==>"+resultArr.toString());
		
		return max;
		
    }
	//-----------------시간복잡도 초과로인한 실패코드(lengthOfLongestSubstring)-----------------------
	
	
	public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int startindex=0;
        int cycleindex=0;
        HashSet<Character> sArr = new HashSet<>();

        while (cycleindex < s.length()) {
        	//System.out.println(startindex+">"+cycleindex);
            if(startindex > cycleindex) break;
            if (!sArr.contains(s.charAt(cycleindex))){
            	
            	System.out.println(s.charAt(cycleindex)+"/"+cycleindex);
            	sArr.add(s.charAt(cycleindex++));
            	//System.out.print("cycleindex==>"+s.charAt(cycleindex));
            	//sArr 안에 중복값이없으면 파라미터로 들어온 문자열 s의 cycleindex번째의 문자를 추가시키고 cycleindex를 1 증가한다.
            	
            	max = Math.max(max, cycleindex - startindex);
                /* Math.max(파라미터1,파라미터2)
                 * 두값을 비교하여 큰수를 max값이 된다.
                 * */
                continue;
            }
            System.out.println("startindex==>"+s.charAt(startindex)+"/"+startindex);
            sArr.remove(s.charAt(startindex++));
            //System.out.print("startindex==>"+s.charAt(startindex));
            //sArr 안에 중복값이 있을경우 파라미터로 들어온 문자열 s의 startindex번째의 문자를 삭제시키고 startindex를 1증가 시킨다.
            //즉 sArr안에 s문자열에서 cycleindex의 위치의 문자와 같은값이 없을때까지 삭제시키면서 startindex를 증가시킨다는 의미
            
        }
        System.out.println(sArr.toString());
        return max;
    }
}
