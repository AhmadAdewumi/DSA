package DS.stacks;

import java.util.Stack;

public class ArrayStack {
    private final int[] data;
    private int top;
    private final int capacity;

    /**
     * Constructs an empty stack with the specified capacity.
     *
     * @param capacity the maximum number of elements the stack can hold. Must be non-negative.
     * @throws IllegalArgumentException if the specified capacity is negative.
     */
    public ArrayStack(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Capacity cannot be negative");

        this.data = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    /**
     * Pushes the specified value onto the stack. If the stack is full, an exception is thrown.
     *
     * @param value the integer value to be added onto the stack.
     * @throws IllegalStateException if the stack is at full capacity.
     */
    public void push(int value) {
        if (top == capacity - 1) {
            throw new IllegalStateException("Stack Overflow error");
        }

        top++;
        data[top] = value;
    }

    /**
     * Removes the top element from the stack and returns it.
     * This operation decreases the size of the stack by one.
     *
     * @return the integer value that was at the top of the stack.
     * @throws IllegalStateException if the stack is empty when this method is called.
     */
    int pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack underflow error");

        int value = data[top];
        top--;
        return value;
    }

    /**
     * Retrieves, but does not remove, the top element of the stack.
     *
     * @return the integer value at the top of the stack.
     * @throws IllegalStateException if the stack is empty.
     */
    int peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        return data[top];
    }

    int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int getSize() {
        return top + 1;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[] (empty)";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            if (i > 0) sb.append(", ");
            sb.append(data[i]);
        }
        sb.append("] <--- TOP");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Popped: " + stack.pop());

        System.out.println("Top element: " + stack.peek());

        System.out.println("Current size: " + stack.getSize());

        stack.push(5);
        stack.push(6);
//        stack.push(7); -- stack overrflow

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
//        System.out.println("Popped: " + stack.pop()); //-- stack underflow

    }
}
