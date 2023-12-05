package com.smol.solutions.N0138_CopyListWithRandomPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0138_CopyListWithRandomPointer {
    /**
     * <h2>Mapping Node to index </></h2>
     * <pre>
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 43.77 MB Beats 10.30% of users with Java
     * </pre>
     */
    public Node copyRandomList(Node head) {
        List<Node> list = new ArrayList<>(); // stores reference to nodes in order
        Map<Node, Integer> map = new HashMap<>(); // stores node paired to index of their order
        
        Node original = head;     // shallow copy of head, so head can be later iterated again
        
        Node headValue = new Node(-1);
        Node values = headValue;
        
        // copy values without random pointers
        int i = 0;
        while (original != null) {
            map.put(original, i); //store original head with its index
            values.next = new Node(original.val); //create new following node with value from original
            values = values.next;
            list.add(values); // store new copied head in order to access by index later
            original = original.next;
            i++;
        }
        
        Node randoms = headValue.next; // shallow copy, so head can be used later on
        
        // fill in random pointers into cloned LinkedList
        while (randoms != null) {
            Node rndHead = head.random;
            if (rndHead != null) {
                int index = map.get(rndHead);
                randoms.random = list.get(index);
            }
            randoms = randoms.next;
            head = head.next;
            i++;
        }
        
        return headValue.next;
    }
    
    
    /** Clonning the list within itself */
    public Node copyRandomList02(Node head) {
        Node iter = head, next;
        
        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;
            
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;
            
            iter = next;
        }
        
        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;
        
        while (iter != null) {
            next = iter.next.next;
            
            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            
            // restore the original list
            iter.next = next;
            
            iter = next;
        }
        
        return pseudoHead.next;
    }
    
    /** <h2>(Hash)Map original node to new node</h2> */
    public Node copyRandomList03(Node head) {
        if (head == null) return null;
        
        Map<Node, Node> map = new HashMap<Node, Node>();
        
        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        
        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}
