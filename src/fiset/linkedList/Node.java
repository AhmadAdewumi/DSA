package fiset.linkedList;

public class Node {
    int data;
    Node next;

    Node(int new_data){
        this.data = new_data;
        this.next = null;
    }

    public static void main(String[] args) {
        //-- create first node, (head)
        Node head = new Node(20);

        //-- link second node
        head.next = new Node(30);
        //-- link third node
        head.next.next = new Node(40);
        //-- link fourth node
        head.next.next.next = new Node(50);

        Node temp = head; //-- why use temp, ans: coz, we never move head, head always  point to the first node
        while (temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
