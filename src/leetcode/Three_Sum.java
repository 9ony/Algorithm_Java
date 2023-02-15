package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Three_Sum {
	/*
	    15. 3Sum
		Companies
		Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.		
		Notice that the solution set must not contain duplicate triplets.
		
		Example 1:
		Input: nums = [-1,0,1,2,-1,-4]
		Output: [[-1,-1,2],[-1,0,1]]
		Explanation: 
		nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
		nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
		nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
		The distinct triplets are [-1,0,1] and [-1,-1,2].
		Notice that the order of the output and the order of the triplets does not matter.

		Example 2:
		Input: nums = [0,1,1]
		Output: []
		Explanation: The only possible triplet does not sum up to 0.

		Example 3:
		Input: nums = [0,0,0]
		Output: [[0,0,0]]
		Explanation: The only possible triplet sums up to 0.
		 
		Constraints:
		3 <= nums.length <= 3000
		-105 <= nums[i] <= 105
	 */
	//tc over
	public List<List<Integer>> threeSum(int[] nums) {
		int numslen = nums.length;
		List<List<Integer>> result= new ArrayList<>();
		Arrays.sort(nums);
		//System.out.println(Arrays.toString(nums));
		while(numslen>2) {
			int lastindex = numslen-1;
	//		System.out.println("lastindex===>"+lastindex);
			for(int startindex=0; startindex<lastindex-1; startindex++) {
		//		System.out.println("startindex===>"+startindex);
				int find = nums[startindex]+nums[lastindex];
				for(int midindex=(startindex+1); midindex<lastindex; midindex++) {
			//		System.out.println("midxindex===>"+midindex);
					if((find+nums[midindex])==0) {
						List<Integer> param = new ArrayList<>();
						param.add(nums[startindex]);
						param.add(nums[midindex]);
						param.add(nums[lastindex]);
						if(!result.contains(param)) {
							result.add(param);
						}
					}
				}
			}
			numslen--;
		}
        return result;
    }
	public List<List<Integer>> threeSum2(int[] nums) {
	    int lastindex = nums.length - 1;
	    List<List<Integer>> result = new ArrayList<>();
	    Arrays.sort(nums);

	    for (int i = 0; i < lastindex - 1; i++) {
	        // 중복된 값 건너뛰기
	        if (i > 0 && nums[i] == nums[i - 1]) continue;

	        int startindex = i + 1;
	        int endindex = lastindex;

	        while (startindex < endindex) {
	            int sum = nums[i] + nums[startindex] + nums[endindex];
	            if (sum == 0) {
	                result.add(Arrays.asList(nums[i], nums[startindex], nums[endindex]));

	                // 중복된 값 건너뛰기
	                while (startindex < endindex && nums[startindex] == nums[startindex + 1]) startindex++;
	                while (startindex < endindex && nums[endindex] == nums[endindex - 1]) endindex--;

	                startindex++;
	                endindex--;
	            } else if (sum < 0) {
	                startindex++;
	            } else {
	                endindex--;
	            }
	        }
	    }

	    return result;
	}
}
