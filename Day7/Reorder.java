
/*Problem Statement:You are given the head of a singly linked-list.
The positions of a linked list of length = 7 for example, can intially be represented as:
[0, 1, 2, 3, 4, 5, 6]
Reorder the nodes of the linked list to be in the following order:
[0, 6, 1, 5, 2, 4, 3]
Notice that in the general case for a list of length = n the nodes are reordered to be in the following order:
[0, n-1, 1, n-2, 2, n-3, ...]*/
class Reorder {
    public void reorderList(ListNode head) {
		// Approach 1 : Reorder Using ArrayList..
        List<ListNode> list=new ArrayList<>();
        if(head==null ){
            return;
        }
        ListNode curr=head;
        while(curr!=null){
            list.add(curr);
            curr=curr.next;
        }
        int i=0;;
        int j=list.size()-1;
        while(i<j){
            list.get(i).next=list.get(j);
            i++;
            if(i>=j){
                break;
            } 
            list.get(j).next=list.get(i);
            j--;      
             }
             list.get(i).next=null;
    }
	public void reorderListUsingStack(ListNode head){
		//Approach 2: Reorder Using Stack....
		Stack<ListNode> stack= new Stack<>();
			 if(head==null || head.next==null){
			   return;
			}
			ListNode temp=head;
			int length=0;
			while(temp!=null){
				stack.push(temp);
				temp=temp.next;
				length++;
			}
		   
			ListNode current=head;
			for(int i=0; i<length/2; i++){
				ListNode tail = stack.pop();
				
				tail.next = current.next;
				current.next = tail;
				current = tail.next;

			}
			current.next = null;
    }
	public static void main(String[]args){
		
		int head=[2,4,6,8];
		reorder.reorderListUsingStack(head);
	}	
}
