package common;

import leetcode.Add_Two_Numbers;

public class RunCode_leetcode {

	public static void main(String[] args) {
		// 1.Tow sum    (Easy)
		/*
		Two_Sum app = new Two_Sum();
		int[] nums = {2,3,4};
		System.out.println(Arrays.toString(app.twoSum(nums, 6)));
		*/
		
		
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
		
	}
}
