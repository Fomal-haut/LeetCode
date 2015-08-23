class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def addTwoNumbers(self, l1, l2):
        first_val = l1.val + l2.val
        if first_val > 9:
            first_val -= 10
        l3 = ListNode(first_val)
        l4 = l3
        isAdd = True if (l1.val + l2.val > 9) else False
        while l1.next is not None and l2.next is not None:
            l1, l2 = l1.next, l2.next
            val = l1.val + l2.val
            if isAdd == True:
                val += 1
            if val > 9:
                isAdd = True
                val -= 10
            else:
                isAdd = False
            next_node = ListNode(val)
            l3.next = next_node
            l3 = next_node
        if l1.next is None:
            if l2.next is not None:
                while l2.next is not None:
                    l2 = l2.next
                    if isAdd == True:
                        l2.val += 1
                        isAdd = False
                    if l2.val > 9:
                        l2.val -= 10
                        isAdd = True
                    l3.next = l2
                    l3 = l2
                if isAdd == True:
                    last = ListNode(1)
                    l3.next = last
            elif isAdd == True:
                next_node = ListNode(1)
                l3.next = next_node
        else:
            while l1.next is not None:
                l1 = l1.next
                if isAdd == True:
                    l1.val += 1
                    isAdd = False
                if l1.val > 9:
                    l1.val -= 10
                    isAdd = True
                l3.next = l1
                l3 = l1
            if isAdd == True:
                last = ListNode(1)
                l3.next = last
        return l4

sol = Solution()
li1 = ListNode(0)
#li3 = ListNode(9)
#li4 = ListNode(0)
#li5 = ListNode(3)
#li1.next = li3
#li3.next = li4
#li4.next = li5
li2 = ListNode(0)
#li6 = ListNode(7)
#li7 = ListNode(8)
#li2.next = li6
#li6.next = li7

listP = sol.addTwoNumbers(li1, li2)
while listP is not None:
    print listP.val
    listP = listP.next

