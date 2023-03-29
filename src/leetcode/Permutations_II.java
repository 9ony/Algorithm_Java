package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {
	/*
	 	Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
		Example 1:
		Input: nums = [1,1,2]
		Output:
		[[1,1,2],
		 [1,2,1],
		 [2,1,1]]

		Example 2:
		Input: nums = [1,2,3]
		Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
		
		Constraints:
		1 <= nums.length <= 8
		-10 <= nums[i] <= 10
	 */
	// 주어신 숫자의 순열을 출력하는데 반복된 숫자는 제외한다
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		boolean map[] = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(nums,result,temp,map);
		return result;
	}
	public void dfs(int[]nums , List<List<Integer>> result,List<Integer> temp,boolean[] map) {
		if(temp.size()==nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=0 ; i<nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !map[i - 1]) {
                continue;
            }
			if(!map[i]) {
				temp.add(nums[i]);
				map[i] = true;
				dfs(nums,result,temp,map);
				temp.remove(temp.size()-1);
				map[i] = false;
			}
		}
	}
}
