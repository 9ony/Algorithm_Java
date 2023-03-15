package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum2 {
	/*
		40. Combination Sum II
		Medium
		Companies
		Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
		Each number in candidates may only be used once in the combination.
		Note: The solution set must not contain duplicate combinations.
		
		Example 1:
		Input: candidates = [10,1,2,7,6,1,5], target = 8
		Output: 
		[
		[1,1,6],
		[1,2,5],
		[1,7],
		[2,6]
		]

		Example 2:
		Input: candidates = [2,5,2,1,2], target = 5
		Output: 
		[
		[1,2,2],
		[5]
		]
		 
		Constraints:
		1 <= candidates.length <= 100
		1 <= candidates[i] <= 50
		1 <= target <= 30
	 */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
		if(candidates.length==1 && candidates[0]>target) return result;
		dfs(candidates,target,0,0,new ArrayList<Integer>(),result);
		return result;
	}
	public void dfs(int[] candidates , int target, int i , int sum , List<Integer> temp,List<List<Integer>> result) {
		if(i>candidates.length) return;
		if(sum>target) return;
		if(sum==target) {
			//base condition 조건 단 target과일치할땐 result에 temp값을 저장후 종료
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		/*
		 * Combination Sum 코드
		for(int j = i ; j < candidates.length; j++) {
			temp.add(candidates[j]);
			System.out.println("add Temp=>"+temp.toString());
			dfs(candidates,target,j,sum+candidates[j],temp,result);
			temp.remove(temp.size()-1); //return 시 요소삭제
			System.out.println("remove Temp=>"+temp.toString());
		} 
		Combination Sum1 코드를 바꿔보았다 중복되는 숫자를 없애면 해당문제를 쉽게 풀수있다.
        현재 인덱스가 이전에 했던 숫자와 같다면 continue로 스킵한다.
		*/
		for(int j = i ; j < candidates.length; j++) {
			if(j > i && candidates[j] == candidates[j-1]) continue; // 겹치는숫자 스킵
			temp.add(candidates[j]);
			dfs(candidates,target,j+1,sum+candidates[j],temp,result);
			temp.remove(temp.size()-1);
		}
	}
}
