package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words {
	/*
	 	30. Substring with Concatenation of All Words
		Hard
		Companies
		You are given a string s and an array of strings words. All the strings of words are of the same length.
		A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
		For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
		Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
		
		Example 1:
		Input: s = "barfoothefoobarman", words = ["foo","bar"]
		Output: [0,9]
		Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
		The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
		The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
		The output order does not matter. Returning [9,0] is fine too.

		Example 2:
		Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
		Output: []
		Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
		There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
		We return an empty array.

		Example 3:
		Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
		Output: [6,9,12]
		Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
		The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
		The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
		The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
		
		Constraints:
		1 <= s.length <= 104
		1 <= words.length <= 5000
		1 <= words[i].length <= 30
		s and words[i] consist of lowercase English letters.
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		Map<Integer,String> wordsMap = new HashMap<>();
		//HashMap으로 할경우 주어진 s안에 words의 단어들을 하나씩 없앨경우 index가아닌 key값으로 가져와서
		//삭제를 하기 때문에 일일이 hashMap키도 탐색하여 삭제하는 불편함이 있어서 ArrayList로 시도
		//List<String> wordsList = new ArrayList<>();
		int duplicated = 0; //주어진 단어들의 합과 일치하는 문자열 시작점을 저장
		int wordsSum = 0; // 주어진 단어들의 총길이
		
		for(int i = 0 ; i < words.length; i++) {
			wordsMap.put(i,words[i]);
			//wordsList.add(words[i]);
			wordsSum += words[i].length();
		}
		
		for(duplicated=0 ;duplicated<=s.length()-wordsSum; duplicated++) {
			String tempStr = s.substring(duplicated,duplicated+wordsSum);
			//Map<Integer,String> tempMap = wordsMap;
			Map<Integer,String> tempMap = new HashMap<>();
			tempMap.putAll(wordsMap);
			System.out.println("map 원본 =>"+wordsMap);
			System.out.println("map 복사본 =>"+tempMap);
			
			int count = 0;
			while(count<tempMap.size()) {
				tempStr = tempStr.replaceFirst(tempMap.get(count), "");
				tempMap.remove(count++);
			}
			
			//tempStr = removeSubString(0,tempMap.size(),tempMap,tempStr);
			
			if(tempStr.isEmpty()) result.add(duplicated);
		}
		
		return result;
    }
	
	public String removeSubString(int index,int max,Map<Integer,String> tempMap,String tempStr) {
		if(tempMap.size()==0) return tempStr;
		if(index>=max && tempMap.size()!=0) index=0;
		if(tempStr.contains(tempMap.get(0))) {
			tempStr = tempStr.replaceFirst(tempMap.get(index), "");
			tempMap.remove(index);
			removeSubString(++index,max,tempMap,tempStr);
		}
		else
			removeSubString(++index,max,tempMap,tempStr);
		return tempStr;
	}
	
	//
	public List<Integer> findSubstring2(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                final String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    System.out.println("-------------------------- j값 =>"+j+"-------");
                    System.out.println(counts);
                    System.out.println(word+","+seen.getOrDefault(word, 0)+1);
                    System.out.println(seen.get(word) +">"+counts.getOrDefault(word, 0));
                    System.out.println("------------------------------");
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                    	System.out.println(seen.get(word) +">"+counts.getOrDefault(word, 0));
                    	System.out.println("seen==>"+seen);
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}

