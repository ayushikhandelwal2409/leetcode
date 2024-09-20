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
import java.util.*;

class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }
        arr.sort(null);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < arr.size(); i++) {
            current.next = new ListNode(arr.get(i));
            current = current.next;
        }
        return dummy.next;
    }
}