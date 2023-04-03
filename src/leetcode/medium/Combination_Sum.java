package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
	/*
	 	39. Combination Sum
		Medium
		Companies
		
		Given an array of distinct integers candidates and a target integer target,
		return a list of all unique combinations of candidates where the chosen numbers sum to target.
		
		You may return the combinations in any order.
		
		The same number may be chosen from candidates an unlimited number of times.
		Two combinations are unique if the frequency of at least one of the chosen numbers is different.
		The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
		 
		Example 1:
		Input: candidates = [2,3,6,7], target = 7
		Output: [[2,2,3],[7]]
		Explanation:
		2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
		7 is a candidate, and 7 = 7.
		These are the only two combinations.

		Example 2:
		Input: candidates = [2,3,5], target = 8
		Output: [[2,2,2,2],[2,3,3],[3,5]]

		Example 3:
		Input: candidates = [2], target = 1
		Output: []
		
		Constraints:
		1 <= candidates.length <= 30
		2 <= candidates[i] <= 40
		All elements of candidates are distinct.
		1 <= target <= 40
	 */
	//주어진 정수로 이루어진 배열에서 합이 타겟이되는 List를 출력
	//배열의 값을 중복해서 사용해도 가능
	//배열안의 조합으로 타겟값과 일치하는 합의 조합을 찾는 문제다.
	//이를 해결하기위해 dfs 알고리즘을 활용하여 걸쳐온 노드들의 합이 target값이 됬을때 해당 노드의 값들을 result 저장한다.
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
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
			System.out.println("result add temp=>"+result.toString());
			return;
		}
		for(int j = i ; j < candidates.length; j++) {
			temp.add(candidates[j]);
			System.out.println("add Temp=>"+temp.toString());
			dfs(candidates,target,j,sum+candidates[j],temp,result);
			temp.remove(temp.size()-1); //return 시 요소삭제
			System.out.println("remove Temp=>"+temp.toString());
		}
	}
}
