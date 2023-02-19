package leetcode;

import common.ListNode;

public class Remove_Nth_Node_From_End_of_List {
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
	// 현재 연결리스트의 길이를 구하고 길이에서 - n을빼서 삭제해야될 노드의 위치를 구하여
	// 해당위치를 건너뛰어서 노드를 가르켜 삭제하는방법
	public ListNode removeNthFromEnd(ListNode head, int n) {
    	int headlen = 0;
        ListNode result = head;
        ListNode temp = head;
        
        while(temp!=null) {
        	//System.out.println(head.val);
        	temp = temp.next;
        	headlen++;
        }
        System.out.println("headlen=>"+headlen);
        if(headlen==0) {
        	return null;
        }        
        if(headlen==n) {
        	return head.next;
        }
        int delindex=headlen-n;
        System.out.println("delindex=>"+delindex);
        int i = 0;
        while(i++<headlen) {
        	if(i==delindex) {
            	result.next = result.next.next;
        	}else {
        		result=result.next;
        	}
        }
    	return head;
    }
	// 참고 풀이 : https://devraphy.tistory.com/m/589 
	/*
	    - 연결 리스트에서 one path 방식으로  two pointers 방식이 있다.
		- 이 문제에서는 two pointers 방식 중 하나인 slow & fast pointers 방식을 사용할 예정이다.
		
		- 우선 slow와 fast라는 이름의 pointer를 생성한다.
		- slow와 fast pointer는 dummy 노드로부터 시작한다.
		- dummy 노드는 문제에서 주어진 head 이전에 무의미한 노드를 갖고 있는 연결 리스트를 말한다.  
		- 이처럼 dummy 노드를 생성하는 이유는 삭제해야 하는 노드가 0번째(= 첫 번째) 노드인 경우를 위해서다.
		 
		- slow와 fast pointer의 거리를 n으로 유지한다.
		- 예를 들어, n이 2라면 slow 포인터는 0번째 노드(= dummy)를 가리키고 fast 포인터는 2번째 노드를 가리키게 한다.
		- 이 둘의 거리를 n으로 유지시킨 채로 fast.next가 null이 아닐 때까지 연결 리스트를 탐색한다.
		
		- 이처럼 거리를 유지하고 탐색을 하는 이유는 다음과 같다.
		- fast가 마지막 노드를 가리킬 때, slow는 연결 리스트의 뒤에서부터 n - 1번째 노드를 가리키게 된다. 
		- slow노드를 기준으로, slow 노드의 다음 노드인 n번째 노드를 삭제하면 된다. 
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
        
		//더미노드 생성
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while(fast.next != null) {
            fast = fast.next;
            if(n-- <= 0) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
