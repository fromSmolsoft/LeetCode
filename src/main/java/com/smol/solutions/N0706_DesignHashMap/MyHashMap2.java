package com.smol.solutions.N0706_DesignHashMap;

/**
 * <h1>706. Design HashMap</h1> <pre>
 * Easy *
 * Design a HashMap without using any built-in hash table libraries.
 * Implement the MyHashMap class:
 * - MyHashMap() initializes the object with an empty map.
 * - void put(int key, int value) inserts a (key, value) pair into the HashMap.
 *      If the key already exists in the map, update the corresponding value.
 * - int get(int key) returns the value to which the specified key is mapped,
 *      or -1 if this map contains no mapping for the key.
 * - void remove(key) removes the key and its corresponding value
 *      if the map contains the mapping for the key.
 *
 * Example 1:
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 *
 * Constraints:
 *     0 <= key, value <= 106
 *     At most 104 calls will be made to put, get, and remove.
 *
 * Hash solution:
 * @Author sgallivan <a href="https://leetcode.com/problems/design-hashmap/solutions/1097755/js-python-java-c-updated-hash-array-solutions-w-explanation/?envType=daily-question&envId=2023-10-04">...</a>
 *  </pre>
 */
public class MyHashMap2 {

    static final int size = 19997; //larger than the number of possible operations (10^4)
    static final int mult = 12582917; //a random large multiplier, preferably a prime
    ListNode[] data;

    public MyHashMap2() {
        this.data = new ListNode[size];
    }

    /**
     * Calculates the hash value for the given key.
     * @param key the key to be hashed
     * @return the calculated hash value
     */
    private int hash(int key) {
        return (int) ((long) key * mult % size);
    }

    /**
     * Inserts a key-value pair into the data structure.
     * @param key the key of the pair to be inserted
     * @param val the value of the pair to be inserted
     */
    public void put(int key, int val) {
        remove(key);
        int      h    = hash(key);
        ListNode node = new ListNode(key, val, data[h]);
        data[h] = node;
    }

    /**
     * Retrieves the value associated with the given key from the data structure.
     * @param key the key to be searched for
     * @return the value associated with the given key, or -1 if the key is not found
     */
    public int get(int key) {
        int      h    = hash(key);
        ListNode node = data[h];
        for (; node != null; node = node.next)
            if (node.key == key) return node.val;
        return -1;
    }

    /**
     * Removes the node with the specified key from the hash table.
     * @param key the key of the node to be removed
     */
    public void remove(int key) {
        int      h    = hash(key);
        ListNode node = data[h];
        if (node == null) return;
        if (node.key == key) data[h] = node.next;
        else for (; node.next != null; node = node.next)
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
    }

}
