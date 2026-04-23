package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListNode {
    private int value;
    private ListNode next;

    ListNode() {
    }

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public static ListNode reverseSLL(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    /**
     * Merges two sorted singly linked lists into a single sorted linked list.
     *
     * @param list1 the head of the first sorted linked list
     * @param list2 the head of the second sorted linked list
     * @return the head of the merged sorted linked list
     */
    public static ListNode mergeSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head;
        ListNode tail;

        if (list1.value <= list2.value) {
            head = list1;
            tail = list1;
            list1 = list1.next;
        } else {
            head = list2;
            tail = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }


        //-- if a list ends, we should jjust append the whole of the remaining second list
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head;
    }

    /**
     * Merges two sorted singly linked lists into a single sorted linked list using a dummy node.
     *
     * @param list1 the head of the first sorted linked list
     * @param list2 the head of the second sorted linked list
     * @return the head of the merged sorted linked list
     */
    public static ListNode mergeSortedListsUsingDummyNode(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); //-- the dummy node to server as our first tail
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }

    public static boolean isLLPalindromeNaiveApproach(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode currentNode = head;

        while (currentNode.next != null) {
            values.add(currentNode.value);
            currentNode = currentNode.next;
        }

        List<Integer> reversedList = new ArrayList<>(values);
        Collections.reverse(reversedList);
        return values.equals(reversedList);
    }

    public static boolean isPalindromeLL2Pointers(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode currentNode = head;

        while (currentNode.next != null) {
            values.add(currentNode.value);
            currentNode = currentNode.next;
        }

        int left = 0, right = values.size() - 1;
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        //-- find middle
        //-- reverse half
        //-- compare both halves
        if (head == null || head.next == null){
            return true;
        }

        //-- we use fast and slow pointer to determine the middle of the SLL
        //-- for even SLL, fast ends up at null
        //-- for odd SLL, fast ends up at last node
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //-- for odd SLL like 1 -> 2 -> 3 -> 2 -> 1,  we don't need to compare the node at the middle, so we move the slow pointer forward
        if (fast != null){
            slow = slow.next;
        }

        //-- since we have 2 halves now, so we reverse the second half, and make the slow pointer(in our example, 1 ...
        //-- the head of the second half
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        //-- we do our comparison by using the second half, since it can be exhausted, and then compare it with the second half
        while(secondHalf != null){
            if (firstHalf.value != secondHalf.value){
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }


    //-- helper method to reverse the LinkedList, omo, Alhamdulillah, getting better, really struggled with this

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
//        list1.next.next.next = new ListNode(4);
//        list1.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
//        list2.next.next.next = new ListNode(9);
//        list2.next.next.next.next = new ListNode(10);

//        System.out.println("Before Reversal");
//        printList(list1);
//
//        list1 = reverseSLL(list1);
//
//        System.out.println("After Reversal");
//        printList(list1);

        System.out.println("Print out merged Linked List");
        ListNode mergeResult = mergeSortedListsUsingDummyNode(list1, list2);
        printList(mergeResult);
    }

}
