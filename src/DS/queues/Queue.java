package DS.queues;

public class Queue {
    private QueueNode front;
    private QueueNode rear;


    /**
     * Adds an element to the rear of the queue.
     *
     * @param value the integer value to be added to the queue
     */
    public void enqueue(int value) {
        //-- inti a new node and pass the val
        QueueNode newNode = new QueueNode(value);

        //-- if the queue is empty, then the rear and front pointer points to the same node
        //-- we point both to our newly created node
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        //-- if the queue is not empty, we point the rear pointer to the newNode
        //-- out rear is equal to the newest enqueue node
        rear.next = newNode;
        rear = newNode;
    }

    /**
     * Removes and returns the front element from the queue.
     * If the queue is empty, a {@code RuntimeException} is thrown.
     *
     * @return the value of the element removed from the front of the queue
     * @throws RuntimeException if the queue is empty
     */
    public int dequeue() {
        //-- if the queue is empty, throw exception
        if (front == null)
            throw new RuntimeException("Queue is empty");

        //--save the current value in front in a temp var
        int value = front.value;
        //-- front is equal to next node, since we will be polling
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    /**
     * Retrieves, but does not remove, the front element of the queue.
     * If the queue is empty, a {@code RuntimeException} is thrown.
     *
     * @return the value of the front element in the queue
     * @throws RuntimeException if the queue is empty
     */
    public int peek() {
        if (front == null) throw new RuntimeException("Queue is empty");

        return front.value;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue contains no elements, otherwise {@code false}
     */
    public boolean isEmpty() {
        return front == null;
    }


    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);

        System.out.println("Dequeue: "  + q.dequeue());
        q.enqueue(30);

        System.out.println("Peek: " + q.peek());
    }
}
