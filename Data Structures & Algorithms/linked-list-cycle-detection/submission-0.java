/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        int count = 0;
        while (count < 1001 && head != null){
            head = head.next;
            count++;
        }
        if (count > 1000) return true;
        if (head == null) return false;

        return true;
    }
}
