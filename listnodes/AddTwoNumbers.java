import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode reverse_l1=reverse_listnode(l1);
        ListNode reverse_l2=reverse_listnode(l2);
    return reverse_listnode(addTwoNumbers_1(reverse_l1,reverse_l2,0));}
    public static ListNode addTwoNumbers_1(ListNode l1,ListNode l2,int carry_bit){
     ListNode result=new ListNode();
     int val1=l1==null?0:l1.val;
     int val2=l2==null?0:l2.val;
     if(l1==null&&l2==null&&carry_bit==0){
         return null;
     }
     if(l1==null&&l2==null){
         result.val=1;
         result.next=null;
         return result;
     }
     l1=l1==null?null:l1.next;
     l2=l2==null?null:l2.next;
     int val=val1+val2+carry_bit;
     carry_bit=val>=10?1:0;
     val=val>=10?val-10:val;
     result.val=val;
     result.next=addTwoNumbers_1(l1,l2,carry_bit);
     return result;
    }
    public static ListNode reverse_listnode(ListNode l1){
        ListNode head=l1;//倒转后的头
        while(l1.next!=null){
            ListNode temp=l1.next;
            l1.next=temp.next;
            temp.next=head;
            head=temp;
        }
        return head;
    }
}
