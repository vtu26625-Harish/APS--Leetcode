/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;

        int lenA = 0;
        while(t1 != null){
            lenA++;
            t1 = t1.next;
        }
        int lenB = 0;
        while(t2 != null){
            lenB++;
            t2 = t2.next;
        }

        t1 = headA;
        t2 = headB;

        if(lenA > lenB){
            int steps = lenA - lenB;
            for(int i = 0 ; i < steps ; i++){
                t1 = t1.next;
            }
        }else{
            int steps = lenB - lenA;
            for(int i = 0 ; i < steps ; i++){
                t2 = t2.next;
            }
        }

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }
}