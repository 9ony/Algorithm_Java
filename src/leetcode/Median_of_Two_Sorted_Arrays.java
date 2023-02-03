package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Median_of_Two_Sorted_Arrays {
	/*	
	 	4. Median of Two Sorted Arrays (hard) 
	    link:https://leetcode.com/problems/median-of-two-sorted-arrays/
	 	Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
		The overall run time complexity should be O(log (m+n)).

		Example 1:
		Input: nums1 = [1,3], nums2 = [2]
		Output: 2.00000
		Explanation: merged array = [1,2,3] and median is 2.
		
		Example 2:
		Input: nums1 = [1,2], nums2 = [3,4]
		Output: 2.50000
		Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
		 
		
		Constraints:
		
		- nums1.length == m
		- nums2.length == n
		- 0 <= m <= 1000
		- 0 <= n <= 1000
		- 1 <= m + n <= 2000
		- -106 <= nums1[i], nums2[i] <= 106
*/
	//time complexity should be O(log (m+n) So, java.util.Arrays.sort() not used beacause this time complexity O(nlogn)
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length>nums2.length) {
			return findMedianSortedArrays(nums2,nums1);
			//길이가 큰 배열이 m에 할당되게 끔 스왑시킴
		}
		//init
		int m = nums1.length;
		int n = nums2.length;
		System.out.println("m,n값 ==>"+m+"/"+n);
		System.out.println("nums1 => "+Arrays.toString(nums1)+", nums2 => "+ Arrays.toString(nums2));
		int left=0;
		int right= m;
		
		
		//while start
		while(left<=right) {
			int partition1 = (left + right) / 2;
			int partition2 = (m+n+1)/2-partition1;
			

			int maxLeftNums1 = (partition1==0) ? Integer.MIN_VALUE : nums1[partition1-1]; 
			int minRightNums1 = (partition1==m) ? Integer.MAX_VALUE : nums1[partition1]; 
			int maxLeftNums2 = (partition2==0) ? Integer.MIN_VALUE : nums2[partition2-1]; 
			int minRightNums2 = (partition2==n) ? Integer.MAX_VALUE : nums2[partition2]; 
			
			if(maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
				if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0;
                } else {
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
			}else if(maxLeftNums1 > minRightNums2) {
				right = partition1 - 1;
			}else {
				left = partition1 + 1;
			}
			System.out.println(maxLeftNums1+"/"+minRightNums1+"/"+maxLeftNums2+"/"+minRightNums2);
			System.out.println((Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0);
		}
		return 0;
    }
}
