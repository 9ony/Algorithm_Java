package leetcode.medium;

import java.util.Arrays;

public class Jump_Game_II {
	/*
	 	45. Jump Game II
		Medium

		You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
		Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
		0 <= j <= nums[i] and
		i + j < n
		Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
		
		Example 1:
		Input: nums = [2,3,1,1,4]
		Output: 2
		Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

		Example 2:
		Input: nums = [2,3,0,1,4]
		Output: 2
		
		Constraints:
		1 <= nums.length <= 104
		0 <= nums[i] <= 1000
		It's guaranteed that you can reach nums[n - 1].
	 */
	// dp bottom up
	public int jump(int[] nums) {
		System.out.println(Arrays.toString(nums));
		int n = nums.length;
        int[] dp=new int[n]; //해당 index위치에서 최소 점프횟수를 넣을 memozation
        for(int i=n-2;i>=0;i--) {
            dp[i]=n;
            for(int j=1;j<=nums[i]&&i+j<n;j++) {
            	System.out.println("i=>"+i+" nums[i]=>"+nums[i]+" , j=> "+j+"/ dp[i]=>"+dp[i]+", 1+dp[i+j] =>"+(1+dp[i+j]));
                dp[i]=Math.min(dp[i],1+dp[i+j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];  
    }
	
	//recursive top-down
	public int jump2(int[] nums) {
        return jump2(nums, 0, new Integer[nums.length]);
    }
    
    private int jump2(int[] nums, int index, Integer[] dp) {
        if(index >= nums.length - 1) {
            return 0;
        }
        
        if(dp[index] != null) {
            return dp[index];
        }
        
        int jumps = nums[index];
        int min = 1000;
        
        for(int i = 1; i <= jumps; i++) {
            min = Math.min(min,  1 + jump2(nums, index + i, dp));
        }
        
        dp[index] = min;
        return min;
    }
}
