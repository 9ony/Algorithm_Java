package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {
	/*
	    18. 4Sum
		Companies
		Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
		0 <= a, b, c, d < n
		a, b, c, and d are distinct.
		nums[a] + nums[b] + nums[c] + nums[d] == target
		You may return the answer in any order.
		
		Example 1:
		Input: nums = [1,0,-1,0,-2,2], target = 0
		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

		Example 2:
		Input: nums = [2,2,2,2,2], target = 8
		Output: [[2,2,2,2]]
		
		Constraints:
		1 <= nums.length <= 200
		-10^9 <= nums[i] <= 10^9
		-10^9 <= target <= 10^9
	 */
	//four pointer
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		if(nums.length<4) return result;
		// i = 제일작은숫자
		// j = 2번째
		// k = 3번째
		// endindex = 제일큰숫자
		// sum4 위 4가지 인덱스를 가진 숫자를 합친값
	    for (int i = 0; i < nums.length-3; i++) {
	        // 중복된 값 건너뛰기
	        if (i > 0 && nums[i] == nums[i - 1]) continue;
	        for(int j = i+1; j<nums.length-2;j++) {
	        	// 중복된 값 건너뛰기
	        	if (j > i+1 && nums[j] == nums[j - 1]) continue;
	        	int k = j + 1;
		        int endindex = nums.length-1;
	
		        while (k < endindex) {
		        	//4개의 합이 오버플로우가 발생하면 sum4가 일단 target보다 큰뜻이므로 endindex--; 후 continue; 처리하였음
		        	int sum4;
		        	try{
		        		sum4 = Math.addExact(nums[i] + nums[j] , nums[k] + nums[endindex]);
		        	}catch(ArithmeticException overflow) {
		        		endindex--;
                        continue;
		        	}
		            if (sum4 == target) {
		                result.add(Arrays.asList(nums[i],nums[j], nums[k], nums[endindex]));
	
		                // 중복된 값 건너뛰기
		                while (k < endindex && nums[k] == nums[k + 1]) k++;
		                while (k < endindex && nums[endindex] == nums[endindex - 1]) endindex--;
	
		                k++;
		                endindex--;
		            } else if (sum4 < target) {
		                k++;
		            } else {
		                endindex--;
		            }
		        }
	        }
	    }

	    return result;
    }
	
	// Two-pointer & recursive Call
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		if(nums.length<4) return result;
		for(int i=0; i<nums.length ; i++) {
		result.add(Ksum(nums,4,nums.length-i,target));
		}
		return result;
    }
	
	public List<Integer> Ksum(int[] nums, int k , int i ,int target ){
		List<Integer> res = new ArrayList<>();
		if(k==2) {
			
		}
		return res;
	}
	
	
}
