package hot100.linked;

import hot100.common.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if  (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1,list2);
            return list2;
        }
    }


}
