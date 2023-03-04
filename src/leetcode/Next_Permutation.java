package leetcode;

import java.util.Arrays;

public class Next_Permutation {
	/*
	 	31. Next Permutation
		Companies
		A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

		For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
		The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
		More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, 
		then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, 
		the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
		
		For example, the next permutation of arr = [1,2,3] is [1,3,2].
		Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
		While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
		Given an array of integers nums, find the next permutation of nums.
		
		The replacement must be in place and use only constant extra memory.
		
		Example 1:
		Input: nums = [1,2,3]
		Output: [1,3,2]

		Example 2:
		Input: nums = [3,2,1]
		Output: [1,2,3]

		Example 3:
		Input: nums = [1,1,5]
		Output: [1,5,1]
		
		Constraints:
		1 <= nums.length <= 100
		0 <= nums[i] <= 100
	 */
	public void nextPermutation(int[] nums) {
        // nums에 속해있는 값들의 순열을 구한후
		// nums값의 다음 순열값을 구하는 알고리즘
		// ex) nums = 213 일경우  {1, 2 ,3} 순열을 구하고 213다음 순열 231이 출력되야함
		int n = nums.length;
		int[] curr = nums;
		System.out.println(Arrays.toString(curr));
		per(nums,0,new boolean[n],n,new int[n]);
		
    }
	
	//주어진 숫자들의 조합으로 순열을 구하는 함수
	public void per(int[] nums, int depth , boolean[] visited, int n , int[] temp) {
		if(depth==n) {
			System.out.println("----------------------");
			for(int i = 0 ; i < temp.length; i++) {
				System.out.print(temp[i]);
			}
			System.out.println("\n----------------------");
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			System.out.println("visited => "+visited[i]);
			System.out.println("i="+i+","+"depth="+depth);
			System.out.println("nums[i]="+nums[i]);
			if(visited[i]==false) {
				visited[i]=true;
				temp[depth]=nums[i];
				this.per(nums, depth+1, visited, n, temp);
				visited[i]=false;
				temp[depth]=0;
			}
		}
	}
	
	public void nextPermutation2(int[] nums) {
        // nums에 속해있는 값들의 순열을 구한후
		// nums값의 다음 순열값을 구하는 알고리즘
		// ex) nums = 213 일경우  {1, 2 ,3} 순열을 구하고 213다음 순열 231이 출력되야함
		int i = nums.length-2;
		while(i>=0 && nums[i]>=nums[i+1]) i--;
		if(i>=0) {
			int j = nums.length-1;
			while(nums[j]<=nums[i]) j--;
			swap(nums,i,j);
		}
		reverse(nums,i + 1, nums.length - 1);
    }
	
	public void swap(int[] nums , int i , int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public void reverse(int[] nums , int i , int j) {
		while(i<j) {
			swap(nums,i++,j--);
		}
	}
}
