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
class Solution {
    public ListNode sortList(ListNode head) {
        // If List contains a single or 0 nodes
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = null;
        ListNode slow = head;
        ListNode fast = head;

        // 2 pointer approach / turtle-hare Algorithm (Finding the middle element)
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;       // slow incremented by 1
            fast = fast.next.next;  // fast incremented by 2
        }

        temp.next = null; // end of first left half

        ListNode l1 = sortList(head); // left half recursive call
        ListNode l2 = sortList(slow); // right half recursive call

        return mergeList(l1, l2); // mergeList Function call
    }

    // Merge Function O(n * logn)
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode ptr = new ListNode(0);
        ListNode curr = ptr;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // For unequal length linked lists
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return ptr.next;
    }
}

