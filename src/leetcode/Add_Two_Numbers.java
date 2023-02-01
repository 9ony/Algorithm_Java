package leetcode;
import common.ListNode;
public class Add_Two_Numbers {
	/*
	 	LeetCode 2.Add Two Numbers (medium)
	 	https://leetcode.com/problems/add-two-numbers/
	 	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
		
		Example Image : Please check through the link.
		
		Example 1:
		Input: l1 = [2,4,3], l2 = [5,6,4]
		Output: [7,0,8]
		Explanation: 342 + 465 = 807.
		
		Example 2:
		Input: l1 = [0], l2 = [0]
		Output: [0]
		Example 3:
		
		Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
		Output: [8,9,9,9,0,0,0,1]
		 
		
		Constraints:
		The number of nodes in each linked list is in the range [1, 100].
		0 <= Node.val <= 9
		It is guaranteed that the list represents a number that does not have leading zeros.
	 */
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode result = new ListNode(0);
			ListNode target = result;
			
		    int carry = 0; //10의자리수 저장할 변수
		    while(l1!=null || l2!=null || carry!=0){
		    	int sum = 0;
		    	if(l1!=null) {
		    		sum+=l1.val; //l1이 가르키는 값이 null이 아니면 sum에 증감
	                l1=l1.next;
		    	}
		    	if(l2!=null) {
		    		sum+=l2.val; //l2이 가르키는 값이 null이 아니면 sum에 증감
	                l2=l2.next;
	            }
		    	sum+=carry; // carry값 더함
		    	carry=sum/10; //sum을 10으로나눠 그몫을 carry에저장 (10의자리수를저장한다)
		    	target.next = new ListNode(sum%10); 
		    	target = target.next; 
		    }
		    return result.next;
	    }
}
