package leetcode;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
	/*
	 	34. Find First and Last Position of Element in Sorted Array
		Companies
		Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
		If target is not found in the array, return [-1, -1].
		You must write an algorithm with O(log n) runtime complexity.
		
		Example 1:
		Input: nums = [5,7,7,8,8,10], target = 8
		Output: [3,4]

		Example 2:
		Input: nums = [5,7,7,8,8,10], target = 6
		Output: [-1,-1]

		Example 3:
		Input: nums = [], target = 0
		Output: [-1,-1]
		
		Constraints:
		0 <= nums.length <= 10^5
		-10^9 <= nums[i] <= 10^9
		nums is a non-decreasing array.
		-10^9 <= target <= 10^9
	 */
	public int[] searchRange(int[] nums, int target) {
		int start=0;
		int end = nums.length-1;
		int[] result = {-1,-1};
		result[0]= findtarget(start,end,target,nums,true); // 첫번째값을 탐색할 경우 true
		result[1]=(result[0]!=-1) ? findtarget(start,end,target,nums,false):-1;
		// 마지막값을 탐색할 경우 false를 보내준다. 그리고 첫번째에서 값을못찾았을경우 -1을 리턴
		return result;
	}
	public int findtarget(int start, int end, int target, int[] nums , boolean check) {
		while(start<=end) {
			int mid=(start+end)/2;
			if(target==nums[mid]) {
				if(check) while(mid>0 && nums[mid-1]==target) mid--;
				else while(mid<nums.length-1 && nums[mid+1]==target) mid++;
				return mid;
			}else if(target<nums[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
