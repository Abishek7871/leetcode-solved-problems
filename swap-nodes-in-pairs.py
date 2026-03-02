class Solution(object):
    def swapPairs(self, head):
        dummy=ListNode(0)
        dummy.next=head
        prev=dummy
        while(prev.next and prev.next.next):
            first=prev.next
            second=prev.next.next
            first.next=second.next
            second.next=prev.next
            prev.next=second
            prev=first
        head=dummy.next
        return head