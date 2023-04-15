package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
	/*
	 	49. Group Anagrams (Medium)
		Given an array of strings strs, group the anagrams together. You can return the answer in any order.
		An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
		
		Example 1:
		Input: strs = ["eat","tea","tan","ate","nat","bat"]
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

		Example 2:
		Input: strs = [""]
		Output: [[""]]

		Example 3:
		Input: strs = ["a"]
		Output: [["a"]]
		 
		Constraints:
		1 <= strs.length <= 104
		0 <= strs[i].length <= 100
		strs[i] consists of lowercase English letters.
	 */
	//아스키코드로 접근해서 풀어볼려고 했는데 생각해보니 다른문자가있더라고 합치면 같아질수 있는걸 고려안함
	public List<List<String>> groupAnagrams1(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		//아스키코드의 합이 같으면 같은그룹
		Map<Integer,Integer> ASCIISum = new HashMap<>();
		for(int i = 0 ; i < strs.length; i++) {
			int sumtemp = 0;
			for(Character c : strs[i].toCharArray()) {
				sumtemp +=c;
			}
			ASCIISum.put(i, sumtemp);
		}
		int i = 0;
		while(i<strs.length) {
			if(ASCIISum.get(i)==null) {
				i++;
				continue;
			}
			List<String> temp = new ArrayList<>();
			for(int j = i+1; j<strs.length; j++) {
				if(ASCIISum.get(j)==null) continue;
				if(ASCIISum.get(j).equals(ASCIISum.get(i))){
					temp.add(strs[j]);
					ASCIISum.remove(j);
				}
			}
			temp.add(strs[i]);
			result.add(new ArrayList<>(temp));
			i++;
		}
        return result;
    }
	//문자를 정렬해서 같은지 비교 
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		Map<Integer,String> AnagramMap = new HashMap<>();
		for(int i = 0 ; i < strs.length; i++) {
			char[] sortstr = new char[strs[i].length()];
			sortstr = strs[i].toCharArray();
			Arrays.sort(sortstr);
			String value = String.valueOf(sortstr);
			AnagramMap.put(i, value);
		}
		int i = 0;
		while(i<strs.length) {
			if(AnagramMap.get(i)==null) {
				i++;
				continue;
			}
			List<String> temp = new ArrayList<>();
			for(int j = i+1; j<strs.length; j++) {
				if(AnagramMap.get(j)==null) continue;
				if(AnagramMap.get(j).equals(AnagramMap.get(i))){
					temp.add(strs[j]);
					AnagramMap.remove(j);
				}
			}
			temp.add(strs[i]);
			result.add(new ArrayList<>(temp));
			i++;
		}
        return result;
    }
	
	public List<List<String>> groupAnagrams(String[] strs) {
		//List<List<String>> result = new ArrayList<>();
		Map<String,ArrayList<String>> AnagramMap = new HashMap<>();
		for(int i = 0 ; i < strs.length; i++) {
			//키값 생성 strs정렬
			char[] sortstr = new char[strs[i].length()];
			sortstr = strs[i].toCharArray();
			Arrays.sort(sortstr);
			String key = String.valueOf(sortstr); //char array를 string으로 변환
			if(!AnagramMap.containsKey(key)) AnagramMap.put(key,new ArrayList<>()); //해당 키값이 없으면 배열생성
			AnagramMap.get(key).add(strs[i]); //해당키값에 strs[i]값을 추가
		}
		//result = new ArrayList<>(AnagramMap.values());
		//return result;
		return new ArrayList<>(AnagramMap.values());
	}
}
