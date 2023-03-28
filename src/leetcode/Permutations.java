package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	/*
	 	46. Permutations (Medium)

		Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
		
		Example 1:
		Input: nums = [1,2,3]
		Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

		Example 2:
		Input: nums = [0,1]
		Output: [[0,1],[1,0]]

		Example 3:
		Input: nums = [1]
		Output: [[1]]
		
		Constraints:
		1 <= nums.length <= 6
		-10 <= nums[i] <= 10
		All the integers of nums are unique
	 */
	//주어진 배열의 숫자의 순열을 반환하는 문제
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		boolean map[] = new boolean[nums.length]; //해당 index의 요소를 사용중일경우 true
		dfs(nums,result,temp,map);
		return result;
	}
	public void dfs(int[]nums , List<List<Integer>> result,List<Integer> temp,boolean[] map) {
		if(temp.size()==nums.length) {
			//temp의 크기와 nums의 길이가 같으면 temp를 result에 추가
			//System.out.println("temp.size ==3 : "+temp.toString());
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int i=0 ; i<nums.length; i++) {
			//System.out.println("i값=>"+i+" map[i] ==> "+Arrays.toString(map)+","+temp.toString());
			if(!map[i]) { //해당요소가 사용중이 아니라면
				//즉 map[i] false일때 temp에 nums[i]값을 추가후 true로 변경
				temp.add(nums[i]);
				map[i] = true;
				dfs(nums,result,temp,map);
				temp.remove(temp.size()-1);
				map[i] = false;
			}
		}
	}
}
