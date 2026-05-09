package DS.hash;

public class SimpleHashMap {
    private static class Node {
        String key;
        int value;
        Node next; //-- points to next node in bucket's chain

        Node(String key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] buckets; //-- an array of buckets, where each bucket is the head of a LL
    private int size; //-- no. of K-V pairs we've stored

    public SimpleHashMap(int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    public int getBucketIndex(String key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    /**
     * Adds a key-value pair to the hash map. If the specified key already exists in the map, its
     * associated value is updated with the new value. Otherwise, a new entry is created and added
     * to the map.
     *
     * @param key   the key to be added or updated in the hash map
     * @param value the value to be associated with the specified key
     */
    public void put(String key, int value) {
        int index = getBucketIndex(key); //-- retrieve the index of the
        Node head = buckets[index]; //-- check the node there currently

        for (Node current = head; current != null; current = current.next) {
            if (current.key.equals(key)) {
                current.value = value; //-- update the existing value
                return; //-- we're done, update complete, no new node
            }
        }

        //-- if not found, add new  node at head

        Node newNode = new Node(key, value, head);
        buckets[index] = newNode;
        size++; //-- increment our size count
    }

    //-- retrieving a value by key
    public Integer get(String key) {
        int index = getBucketIndex(key);

        for (Node current = buckets[index]; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }

        return null;
    }

    /**
     * Removes the entry for the given key from the hash map if it is present and returns the
     * associated value. If the key is not found, returns null.
     *
     * @param key the key whose mapping is to be removed from the hash map
     * @return the value previously associated with the specified key, or null if the key was not found
     */
    public Integer remove(String key) {
        int index = getBucketIndex(key);
        Node head = buckets[index];

        if (head == null) return null;

        //-- when removing the head node, it is a soecial case
        if (head.key.equals(key)) {
            buckets[index] = head.next;
            size--;
            return head.value;
        }

        //-- search for the node before the ione we waana remove
        for (Node current = head; current.next != null; current = current.next) {
            if (current.next.key.equals(key)) {
                int removedValue = current.next.value;
                current.next = current.next.next; //-- we point our next pointer to the node after the deleted node
                size--;
                return removedValue;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //----- LET'S FRIGGING TEST!!!!!!!!!!!!!!!!!!!!!!!1

    public static void main(String[] args) {
        SimpleHashMap map = new SimpleHashMap(5);  // Small capacity to force collisions

        System.out.println("=== EMPTY MAP ===");
        System.out.println("Size: " + map.size());
        System.out.println("Get 'Musa': " + map.get("Musa"));
        System.out.println("Is empty: " + map.isEmpty());

        System.out.println("\n=== ADDING VENDORS ===");
        map.put("Musa", 42);
        map.put("Chidi", 99);
        map.put("Amina", 7);
        map.put("Emeka", 55);
        map.put("Ngozi", 12);

        System.out.println("Size after 5 puts: " + map.size());
        System.out.println("Get 'Musa': " + map.get("Musa"));
        System.out.println("Get 'Chidi': " + map.get("Chidi"));
        System.out.println("Get 'Amina': " + map.get("Amina"));
        System.out.println("Get 'Emeka': " + map.get("Emeka"));
        System.out.println("Get 'Ngozi': " + map.get("Ngozi"));
        System.out.println("Get 'Zainab' (not added): " + map.get("Zainab"));

        System.out.println("\n=== UPDATING EXISTING KEY ===");
        System.out.println("Musa's old value: " + map.get("Musa"));
        map.put("Musa", 100);  // Update Musa
        System.out.println("Musa's new value: " + map.get("Musa"));
        System.out.println("Size (should still be 5): " + map.size());

        System.out.println("\n=== REMOVING ===");
        System.out.println("Removing 'Chidi': " + map.remove("Chidi"));
        System.out.println("Get 'Chidi' after removal: " + map.get("Chidi"));
        System.out.println("Size after removal: " + map.size());

        System.out.println("\n=== REMOVING HEAD NODE ===");
        // We don't know who's at the head, but remove handles it
        System.out.println("Removing 'Emeka': " + map.remove("Emeka"));
        System.out.println("Get 'Emeka' after removal: " + map.get("Emeka"));
        System.out.println("Size: " + map.size());

        System.out.println("\n=== REMOVING SOMETHING NOT THERE ===");
        System.out.println("Removing 'Zainab': " + map.remove("Zainab"));
        System.out.println("Size (unchanged): " + map.size());

        System.out.println("\n=== ADD AFTER REMOVALS ===");
        map.put("Zainab", 88);
        System.out.println("Get 'Zainab': " + map.get("Zainab"));
        System.out.println("Get 'Musa' (should still be 100): " + map.get("Musa"));
        System.out.println("Size: " + map.size());
    }
}
