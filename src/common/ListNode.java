package common;

public class ListNode {
	public int val;
	public ListNode next;
	public int size;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	public ListNode InputInt(int... intParam) {
		ListNode head = new ListNode(0);
		ListNode last = head;
		ListNode pointer;
		for(int i = 0; i < intParam.length; i++) {
			pointer = new ListNode(intParam[i]);
			last.next = pointer;
			last = last.next;
		}
		return head.next;
	}
	//ListNode값 String으로 출력하는 메서드
	public String toStringListNode() {
		String str = "";
		ListNode result = this;
		while(result!=null) {
			str += ""+result.val;
			result = result.next;
		}
		return str;
	}
	
	
}
