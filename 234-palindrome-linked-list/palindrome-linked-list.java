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
    public boolean isPalindrome(ListNode head) {
        // ListNode thead=head;
        // ArrayList<String>list=new ArrayList<>();
        // while(thead!=null){
        //     list.add(String.valueOf(thead.val));
        //     thead=thead.next;
        // }
        // int start=0,end=list.size()-1;
        // while(start<end){
        //     if(!list.get(start++).equals(list.get(end--)))return false;
        // }
        // return true;
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode thead=head;
        slow=(fast==null)?revList(slow):revList(slow.next);//handle odd even case
        while(slow!=null){
            if(slow.val!=thead.val)return false;
            slow=slow.next;
            thead=thead.next;
        }
        return true;
    }
    public ListNode revList(ListNode head){
        ListNode prev=null,cur=head,next=head;
        while(cur!=null){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}