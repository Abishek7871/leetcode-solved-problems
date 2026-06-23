class Solution:
    def removeElements(self, head, val):

        d = ListNode(0)
        d.next = head

        temp = d

        while temp.next:

            if temp.next.val == val:
                temp.next = temp.next.next
            else:
                temp = temp.next

        return d.next
