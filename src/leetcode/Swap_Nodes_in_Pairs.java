package leetcode;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Swap_Nodes_in_Pairs {
	/*
	  	24. Swap Nodes in Pairs
		Companies
		Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
		
		Example 1:
		Input: head = [1,2,3,4]
		Output: [2,1,4,3]

		Example 2:
		Input: head = []
		Output: []
		Example 3:
		Input: head = [1]
		Output: [1]
		 
		Constraints:
		The number of nodes in the list is in the range [0, 100].
		0 <= Node.val <= 100
	 */
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode result = head.next; //result 노드가 head의 2번째를 가르킨다
		ListNode temp = head.next.next; //재귀함수 파라미터로 넘어갈 노드가 head의 3번째 값을 가르킨다
		result.next = head; //result의 두번째로 가르킬값이 head의 첫번째값을 가르킨다.
		head.next=swapPairs(temp);
		
		return result;
    }
}
