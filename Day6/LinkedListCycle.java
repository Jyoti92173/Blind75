/*
Problem Statement: Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
There is a cycle in a linked list if at least one node in the list that can be visited again by following the next pointer.Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
*/


class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
		// Approach : LinkedList
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;
        }
         return false;
    }
	public static void main(String[] args){
		int head[]={[1,2,3,4};
		int index=1;
		LinkedListCycle linkedlistcycle=new LinkedListCycle();
		System.out.println(linkedlistcycle.hasCycle(head));
	}
}
