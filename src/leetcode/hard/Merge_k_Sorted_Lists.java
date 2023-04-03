package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class Merge_k_Sorted_Lists {
	/*
	  	23. Merge k Sorted Lists
		Companies
		You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
		Merge all the linked-lists into one sorted linked-list and return it.
		
		Example 1:
		Input: lists = [[1,4,5],[1,3,4],[2,6]]
		Output: [1,1,2,3,4,4,5,6]
		Explanation: The linked-lists are:
		[
		  1->4->5,
		  1->3->4,
		  2->6
		]
		merging them into one sorted list:
		1->1->2->3->4->4->5->6

		Example 2:
		Input: lists = []
		Output: []

		Example 3:
		Input: lists = [[]]
		Output: []
		
		Constraints:
		k == lists.length
		0 <= k <= 104
		0 <= lists[i].length <= 500
		-104 <= lists[i][j] <= 104
		lists[i] is sorted in ascending order.
		The sum of lists[i].length will not exceed 104.
	 */
	//소요시간 => 195ms 
	public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode result = null;
        if(n<2){
            if(n==0){
                return result;
            }else{
                return lists[0];
            }
        }
        for(int i = 0 ; i < n-1 ; i ++) {
        	lists[i+1] = sortedNode(lists[i],lists[i+1]);
            result = lists[i+1];
        }
        return result;
    }
    public ListNode sortedNode(ListNode list1 , ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;
        while(list1!=null||list2!=null) {
        	if(list2==null) {
        		result.next = list1;;
        		list1 = list1.next;
        	}else if(list1==null){
        		result.next = list2;
        		list2 = list2.next;
        	}
        	else if(list1.val>=list2.val) {
        		result.next = list2;
        		list2 = list2.next;
        	}else {
        		result.next = list1;
        		list1 = list1.next;
        	}
        	result = result.next;
        }
    	return dummy.next;
    }
    
    //소요시간 => 3ms code
    ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head = null, curr = head;
        ListNode curr1 = list1, curr2 = list2;
        while (curr1 != null && curr2 != null) {

            ListNode minNode = null;
            if (curr1.val < curr2.val) {
                minNode = curr1;
                curr1 = curr1.next;
            } else {
                minNode = curr2;
                curr2 = curr2.next;
            }

            if (head == null) {
                curr = head = minNode;
            } else {
                curr.next = minNode;
                curr = curr.next;
            }
        }

        if (curr1 != null) {
            curr.next = curr1;
        } else if (curr2 != null) {
            curr.next = curr2;
        }

        return head;
    }

    ListNode mergeSort(ListNode[] lists, int beg, int end) {

        if (beg == end) {
            return lists[beg];
        }

        int mid = (beg + end) / 2;
        ListNode list1 = mergeSort(lists, beg, mid);
        ListNode list2 = mergeSort(lists, mid + 1, end);
        ListNode head = merge(list1, list2);
        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }
}
