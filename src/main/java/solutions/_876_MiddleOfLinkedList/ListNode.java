package solutions._876_MiddleOfLinkedList;

/** Definition for singly-linked list. */
public class ListNode {

   public int      val;
    ListNode next;

    ListNode() {}

    public ListNode(int val) {this.val = val;}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
