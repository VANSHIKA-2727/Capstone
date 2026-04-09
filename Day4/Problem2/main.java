//PriorityQueue(minHeap)
package Day4.Problem2;
import java.util.*;
class ListNode402 {
    int val;
    ListNode402 next;
    
    ListNode402() {}
    ListNode402(int val) { this.val = val; }
    ListNode402(int val, ListNode402 next) { this.val = val; this.next = next; }
}

public class main {
    public static void main(String[] args) {
        ListNode402 l1 = new ListNode402(1);
        l1.next = new ListNode402(4);
        l1.next.next = new ListNode402(5);
        ListNode402 l2 = new ListNode402(1);
        l2.next = new ListNode402(3);
        l2.next.next = new ListNode402(4);
        ListNode402 l3 = new ListNode402(2);    
        l3.next = new ListNode402(6);
        ListNode402[] lists = {l1,l2,l3};

        ListNode402 result = mergeLists(lists);
        
        // Print the merged list
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
    
    static ListNode402 mergeLists(ListNode402[] lists) {
        PriorityQueue<ListNode402> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode402 head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }
        ListNode402 dummy = new ListNode402(0);
        ListNode402 tail = dummy;
        while(!pq.isEmpty()) {
            ListNode402 node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}