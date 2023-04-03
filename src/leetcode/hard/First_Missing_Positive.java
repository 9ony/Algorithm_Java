package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class First_Missing_Positive {
	/*
	 	41. First Missing Positive   (Hard)
		Companies
		Given an unsorted integer array nums, return the smallest missing positive integer.
		You must implement an algorithm that runs in O(n) time and uses constant extra space.
		
		Example 1:
		Input: nums = [1,2,0]
		Output: 3
		Explanation: The numbers in the range [1,2] are all in the array.

		Example 2:
		Input: nums = [3,4,-1,1]
		Output: 2
		Explanation: 1 is in the array but 2 is missing.

		Example 3:
		Input: nums = [7,8,9,11,12]
		Output: 1
		Explanation: The smallest positive integer 1 is missing.
		
		Constraints:
		1 <= nums.length <= 105
		-2^31 <= nums[i] <= 2^31 - 1
	 */
	//정렬되지 않은 정수에서 누락된 가장작은 정수를 출력하는 문제
	//공간 복잡도 제약조건은 O(n).
	public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            //nums[i] == i+1 ; 현재위치에 알맞은 숫자이므로 스킵
            //0보다 작을경우 스킵
            //nums의 길이보다 nums[i]가 클경우 스킵
            
            else if(nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
            // nums[nums[i]-1] != nums[i] 코드는
            // nums[i]의 값이 자신의 인덱스 위치에 없다는 것을 의미함
            // ex) i = 100 이고 nums[i] 값이 1일때 즉 nums[i] = 1
            //     -> nums[1 (=nums[100]) - 1 ] => nums[0] != nums[i] (1) 
            else i++;
        }
        //System.out.println(Arrays.toString(nums));
        i=1;
    	while(i-1<nums.length && nums[i-1]==(i)) i++;
		return i;
    }
	//nums 배열안에 curridx위치의 값과 previdx위치의 값을 바꿔주는 메서드
	public void swap(int[] nums , int curridx , int previdx) {
		int temp = nums[curridx];
		nums[curridx] = nums[previdx];
		nums[previdx] = temp;
	}
}
