public class addEvenList {
public ListNode addEvenList_1(ListNode head){
    if(head==null||head.next==null){
        return head;
    }
    ListNode odd_tail=head;//已经排序好的奇数序列的末尾节点
    ListNode even_tail=head.next;//已经排序好的偶数序列的末尾节点
    while(even_tail!=null&&even_tail.next!=null){
    ListNode temp=even_tail.next;
    even_tail.next=temp.next;
    temp.next= odd_tail.next;
    odd_tail.next=temp;
    even_tail=even_tail.next;
    odd_tail=odd_tail.next;
    }
    return head;
}
}
