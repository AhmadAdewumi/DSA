package fiset.linkedList;

public class LinkedListOps {
    static void traverseLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }


    static void traverseListRecursively(Node head) {
        //-- base case, when the head is not null
        if (head == null) {
            System.out.println();
            return;
        }

        //--  print the head node data
        System.out.print(head.data);

        //-- print arrow if it is not the last node ( as lost node points to null
        if (head.next != null) {
            System.out.print(" -> ");
        }

        //-- move to the next node
        traverseListRecursively(head.next);
    }

    static Node insertAtFront(Node head, int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
    }

    static Node insertAtEnd(Node head, int x) {
        Node newNode = new Node(x);

        //-- if the linked list is empty we make the head as the newNode and return
        if (head == null)
            return newNode;

        //-- store the head reference in a temp pointer
        Node temp = head;

        //-- traverse till the last node
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        //-- change next pointer of the tail to point to the new node
        tail.next = newNode;

        return head;
    }

    //-- Hare and Tortoise Approach
    //-- initialize 2 pointers  (fast and slow)
    //-- move slow once and fast twice
    //-- by the time fast pointer reaches end, slow will be in the middle already
    static Node findMiddleNodeInOnePass(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node insertNodeAtPos(Node head, int pos, int val) {
        //-- if the position is negative or zero, we return the ref to the head
        if (pos < 1)
            return head;

        //-- if  the pos given is 1, we insert at front
        if (pos == 1) {
            Node newNode = new Node(val);
            newNode.next = head;
            return newNode;
        }

        Node current = head; //-- init our pointer

        //-- traverse to the node that is before the new node, and also the current must not be null
        //-- ... handles case where the pos sent is out of bound for the linked list
        for (int i = 0; i < (pos - 1) && current != null; i++) {
            current = current.next;
        }

        //-- to guard against pos that doesn't exist in the list
        if(current == null)
            return head; //-- Invalid position, nothing is done , keep the list exactly as it was

        //-- take care of creating the new node and updating the next pointers
        Node newNode = new Node(val);
        newNode.next =  current.next;
        current.next = newNode;


        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = new Node(40);
        head.next.next.next = new Node(50);

        int x = 18, y = 17;
        head = insertAtFront(head, x);
        head = insertAtEnd(head, y);

        head = insertNodeAtPos(head, 3, 67);
//        traverseLinkedList(head);
        traverseListRecursively(head);

        Node middleNode = findMiddleNodeInOnePass(head);
        System.out.println("The middle node is: " + middleNode.data);

    }
}
