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
    public ListNode middleNode(ListNode head) {
        int sz=0;
        ListNode temp = new ListNode();
        temp=head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        temp=head;
        int middle =(sz/2);
        for(int i=0; i<middle; i++){
            temp=temp.next;
        }
        head=temp;
        return head;
    }
}