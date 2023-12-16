package com.smol.solutions.N0146_LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * <h2>DoubleLinkedList with HashMap </h2>
 * <pre>
 * Runtime 40ms Beats 70.90% of users with Java
 * Memory 120.62MB Beats 40.04% of users with Java
 * </pre>
 */
public class LRUCache01 implements LRUCacheInterface {
    
    private final int capacity;
    private DLinkedList list;
    private Map<Integer, Node> map;
    
    /** <h2>DoubleLinkedList with HashMap </h2> */
    public LRUCache01(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        list = new DLinkedList();
    }
    
    @Override
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.moveToHead(node);
            return node.val;
        } else return -1;
    }
    
    @Override
    public void put(int key, int value) {
        Node node;
        
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            list.moveToHead(node);
        } else {
            node = new Node();
            node.key = key;
            node.val = value;
            list.addFirst(node);
        }
        map.put(key, node);
        
        if (map.size() > capacity) {
            Node remove = list.removeTail();
            map.remove(remove.key);
        }
    }
    
    
    // ## Node class ------------
    
    protected class Node {
        Node prev;
        Node next;
        int key;
        int val;
    }
    
    
    // ## DoubleLinkedList class -----------
    
    public class DLinkedList {
        private Node head, tail;
        
        public DLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        
        public void addFirst(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
        }
        
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        public void moveToHead(Node node) {
            remove(node);
            addFirst(node);
        }
        
        public Node removeTail() {
            if (tail.prev != head) {
                Node removed = tail.prev;
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                return removed;
                
            } else return null;
        }
    }
    
}
