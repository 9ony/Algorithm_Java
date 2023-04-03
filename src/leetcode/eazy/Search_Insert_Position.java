package leetcode.eazy;

public class Search_Insert_Position {
/*
 	35. Search Insert Position
	Companies
	Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
	You must write an algorithm with O(log n) runtime complexity.
	
	Example 1:
	Input: nums = [1,3,5,6], target = 5
	Output: 2

	Example 2:
	Input: nums = [1,3,5,6], target = 2
	Output: 1

	Example 3:
	Input: nums = [1,3,5,6], target = 7

	Output: 4

	Constraints:
	1 <= nums.length <= 104
	-104 <= nums[i] <= 104
	nums contains distinct values sorted in ascending order.
	-104 <= target <= 104
 */
	public int searchInsert(int[] nums, int target) {
		int start = 0 ;
		int end = nums.length-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(nums[mid]==target) {
				return mid;
			}else if (nums[mid]>target) {
				end = mid-1;
                if(end<0) {
					return 0;
				}
				if(nums[end]<target) {
					// mid위치에 값이 target보다 컸는데
					// mid-1 위치의 값이 target보다 작다면 
					// 주어진 nums에 target이 없다는 의미이므로 mid값이 target의 인덱스가 되므로
					// mid값을 return 해줘야한다.
					return mid;
				}
			}else {
				start = mid+1;
                if(start>nums.length-1) {
					return start;
				}
			}
		}
		return 0;
    }
}
