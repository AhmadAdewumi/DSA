package DS.queues;

public class CircularQueue {
    private final int[] arr;     // underlying array (fixed size)
    private int front;            // index of oldest element
    private int rear;             // index of newest element
    private int size;             // current count of elements
    private final int capacity;   // max number of elements

    public CircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Array capacity must be positive");
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1; //-- -1 signals empty queue
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Adds an element to the rear of the circular queue.
     *
     * @param value the integer value to be added to the circular queue
     * @throws IllegalStateException if the circular queue is full
     */
    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue is full");

        //-- we advance the rear pointer to the next slot, it wraps to the front, in cae it is at full cap, but we made some dequeues
        rear = (rear + 1) % capacity;

        //-- write value into the slot
        arr[rear] = value;

        //-- increment size
        size++;
    }

    /**
     * Removes and returns the front element from the circular queue.
     * If the circular queue is empty, an {@code IllegalStateException} is thrown.
     *
     * @return the value of the element removed from the front of the circular queue
     * @throws IllegalStateException if the circular queue is empty
     */
    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");


        //-- save the value at the current front, the one to be polled, so we can return it
        int value = arr[front];

        //-- advance ront to next element, it also wraps also
        front = (front + 1) % capacity;

        //-- decrement count
        size--;

        //-- we return the saved value
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return arr[front];
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return capacity;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("data=");
        sb.append(java.util.Arrays.toString(arr));
        sb.append(", front=").append(front);
        sb.append(", rear=").append(rear);
        sb.append(", size=").append(getSize());
        sb.append(", capacity=").append(getCapacity());

        if (size > 0){
            sb.append(", elements[");

            for (int i = 0; i < size; i++) {
                if (i>0) sb.append(", ");
                int idx = (front + i)%capacity;
                sb.append(arr[idx]);
            }
            sb.append("]");
        }

        return sb.toString();
    }
}
