package DS.stacks;

import java.util.ArrayDeque;

public class LinkedStack {
    private StackNode top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(int value){
        StackNode newNode = new StackNode(value);

        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop(){
        if (isEmpty())
            throw  new RuntimeException("Stack is empty (S.U)");
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public int peek(){
        if (isEmpty())
            throw  new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty(){
        return top ==null;
    }

    public int getSize(){
        return size;
    }

}
