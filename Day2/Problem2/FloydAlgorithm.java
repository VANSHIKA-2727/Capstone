
// class Node {
//     int data;
//     Node next;
// }

// public class FloydAlgorithm {
//     public static void main(String[] args) {

//         Node head = new Node();
//         head.data = 1;

//         head.next = new Node();
//         head.next.data = 2;

//         head.next.next = new Node();
//         head.next.next.data = 3;

//         head.next.next.next = new Node();
//         head.next.next.next.data = 4;

//         // Creating cycle
//         head.next.next.next.next = head.next;

//         Node slow = head;
//         Node fast = head;

//         boolean hasCycle = false;

//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;

//             if (slow == fast) {
//                 hasCycle = true;
//                 break;
//             }
//         }

//         if (hasCycle) {
//             System.out.println("cycle detected");
//         } else {
//             System.out.println("no cycle");
//         }
//     }
// }



class Node {
    int data;
    Node next;
}

public class FloydAlgorithm {
    public static void main(String[] args) {

        Node head = new Node();
        head.data = 1;

        head.next = new Node();
        head.next.data = 2;

        head.next.next = new Node();
        head.next.next.data = 3;

        head.next.next.next = new Node();
        head.next.next.next.data = 4;

        // ❌ No cycle here (last node points to null)

        Node slow = head;
        Node fast = head;

        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            System.out.println("cycle detected");
        } else {
            System.out.println("no cycle");
        }
    }
}