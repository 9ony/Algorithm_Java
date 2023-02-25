package leetcode;

import common.ListNode;

public class Reverse_Nodes_in_kGroup {
	/*
	 	25. Reverse Nodes in k-Group
		Companies
		Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
		k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes,
		 in the end, should remain as it is.
		You may not alter the values in the list's nodes, only nodes themselves may be changed.
		
		Example 1:
		<before>
				1 -> 2 -> 3 -> 4 -> 5
		<after>
				2 -> 1 -> 4 -> 3 -> 5
		Input: head = [1,2,3,4,5], k = 2
		Output: [2,1,4,3,5]

		Example 2:
		<before>
				1 -> 2 -> 3 -> 4 -> 5
		<after>
				3 -> 2 -> 1 -> 4 -> 5
		Input: head = [1,2,3,4,5], k = 3
		Output: [3,2,1,4,5]
		
		Constraints:
		The number of nodes in the list is n.
		1 <= k <= n <= 5000
		0 <= Node.val <= 1000
		 
		Follow-up: Can you solve the problem in O(1) extra memory space?*/
	//recursion code , sc = O(1) tc=O
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while(curr!=null && count!=k) {
			count++;
			curr = curr.next;
		}
		System.out.println(count);
		
		if(count == k ) {
			curr = reverseKGroup(curr, k);
			while(count-- > 0) {
				ListNode temp = head.next;
				head.next = curr;
				curr = head;
				head = temp;
			}
	        head = curr;
		}
		return head;
    }
}
