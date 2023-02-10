package common;

import leetcode.Regular_Expression_Matching;

public class RunCode_leetcode {

	public static void main(String[] args) {
		// 1.Tow sum    (Easy)
		/*
		Two_Sum app = new Two_Sum();
		int[] nums = {2,3,4};
		System.out.println(Arrays.toString(app.twoSum(nums, 6)));
		*/
		
		/*
		// 2.Add Two Numbers  (Medium)
		Add_Two_Numbers app = new Add_Two_Numbers();
		ListNode l1 = new ListNode(4);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(2);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(7);
		ListNode result = app.addTwoNumbers(l1, l2);
		
		System.out.println(result.toStringListNode());
		*/
		
		/*
		// 3. Longest Substring Without Repeating Characters  (Medium)
		Longest_Substring_Without_Repeating_Characters app = new Longest_Substring_Without_Repeating_Characters();
		// app.lengthOfLongestSubstring 시간복잡도초과로인한 실패
		//System.out.println(app.lengthOfLongestSubstring("abcabcaa"));
		System.out.println(app.lengthOfLongestSubstring2("ababcdc"));
		*/
		
		/*
		// 4. Median of Two Sorted Arrays   (Hard)
		Median_of_Two_Sorted_Arrays app = new Median_of_Two_Sorted_Arrays();
		//int[] nums1 = {4,8,10};
		//int[] nums2 = {3,7,11,15};
		int[] nums1 = {5};
		int[] nums2 = {6,7,8,9,10,11,12,13};
		// 3 4 7 8 10 11 15
		System.out.println(app.findMedianSortedArrays(nums1, nums2));
		*/
		/*
		// 5. Longest Palindromic Substring  (Medium)
		Longest_Palindromic_Substring app = new Longest_Palindromic_Substring();
		System.out.println(app.longestPalindrome3("abcbaaaaaaa"));
		*/
		/*
		// 6. Zigzag Conversion  (Medium)
		Zigzag_Conversion app = new Zigzag_Conversion();
		System.out.println(app.convert("A", 2));
		*/
		/*
		// 7. Reverse Integer  (Medium)
		Reverse_Integer app = new Reverse_Integer();
		System.out.println(app.reverse(01111));
		System.out.println();
		*/
		/*
		//8. String to Integer (atoi)  (Medium)
		String_to_Integer app = new String_to_Integer();
		System.out.println(app.myAtoi("        000000-42a1234"));		
		*/
		/*
		//9. Palindrome Number    (Easy)
		
		Palindrome_Number app = new Palindrome_Number();
		System.out.println(app.isPalindrome(1221));
		*/
		
		
		//10. Regular Expression Matching   (Hard)
		
		Regular_Expression_Matching app = new Regular_Expression_Matching();
		System.out.println(app.isMatch("aab", "c*a*b"));
		System.out.println(app.isMatch("mississippi", "mis*is*p*."));
		System.out.println("----------------------------");
		
	}
}
