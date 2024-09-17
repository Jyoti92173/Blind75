/*
Problem Statement: You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
The new list should be made up of nodes from list1 and list2.
*/

class MergeSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// Approach: Brute Force............
       List<Integer> values = new ArrayList<>();
        ListNode current = list1;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        current = list2;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        Collections.sort(values);
        if (values.isEmpty())
         return null;

        ListNode sortedList = new ListNode(values.get(0));
        ListNode tail = sortedList;

        for (int i = 1; i < values.size(); i++) {
            tail.next = new ListNode(values.get(i));
            tail = tail.next;
        }

        return sortedList;
    }
	public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
		// Approach : LinkedList
	   if(list1 == null) 
		   return list2;
        if(list2 == null) 
			return list1;

        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
	}
	public static void main(String[] args){
		MergeSortedList msl=new MergeSortedList();
		int list1[] = {1,2,4};
		int list2[] = {1,3,5};
		System.out.println(msl.mergeTwoLists(list1,list2));
		System.out.println(msl.mergeTwoLists1(list1,list2));
	}
}