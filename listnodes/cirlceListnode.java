public class cirlceListnode {
    public boolean have_circle(ListNode head){
        if(head==null){
            return false;
        }
        ListNode quick_pointer=head.next;
        ListNode slow_pointer=head;
        while(quick_pointer!=null&&quick_pointer!=slow_pointer){
            quick_pointer=quick_pointer.next;
            if(quick_pointer==null){
                return false;
            }
            quick_pointer=quick_pointer.next;
            slow_pointer=slow_pointer.next;
        }
        return quick_pointer != null;
    }
}
