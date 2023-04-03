package leetcode.medium;

import java.util.Arrays;

public class ThreeSum_Closest {
	/*
		16. 3Sum Closest
		Companies
		Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
		Return the sum of the three integers.
		
		You may assume that each input would have exactly one solution.
		
		Example 1:
		Input: nums = [-1,2,1,-4], target = 1
		Output: 2
		Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

		Example 2:
		Input: nums = [0,0,0], target = 1
		Output: 0
		Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
		
		Constraints:
		3 <= nums.length <= 500
		-1000 <= nums[i] <= 1000
		-104 <= target <= 104
		*/
	public int threeSumClosest(int[] nums, int target) {
		int diff=Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);
		for(int i = 0; i<nums.length-2;i++) {
			int lastindex=nums.length-1;
			int midindex=i+1;
			while(midindex<lastindex) {
				int sum3=nums[i]+nums[midindex]+nums[lastindex];
				if(Math.abs(sum3-target)<diff) {
					result=sum3;
					diff=Math.abs(sum3-target);
				}
				if (sum3>=target) {
					lastindex--;
				}else midindex++;
			}
		}
		return result;
	}
}
