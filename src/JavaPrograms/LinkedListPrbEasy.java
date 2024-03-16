package JavaPrograms;

public class LinkedListPrbEasy {
    public static void main(String[] args) {
//        SingleListNode node = new SingleListNode();
//        node.insertFirst(70);
//        node.insertFirst(90);
//        node.insertFirst(10);
//        node.insertLast(44);
//        node.insertMiddle(33,2);
//        node.display();
//        System.out.println(node.deleteMiddle(2));
//        node.display();
//        System.out.println(node.size);

//        DoubleListNode nd = new DoubleListNode();
//        nd.insertFirst(1);
//        nd.insertLast(3);
//        nd.insertLast(5);
//        nd.insertLast(7);
//        nd.insertMiddle(2,1);
//        nd.display();
//        nd.insertMiddle(100,1);
//        nd.display();
//        System.out.println(nd.deleteFirst());
//        System.out.println(nd.deleteLast());
//        nd.display();
//        System.out.println(nd.deleteMiddle(2));

//        SingleListNode l1 = new SingleListNode();
//        SingleListNode l2 = new SingleListNode();
//        l1.insertFirst(4);
//        l1.insertFirst(2);
//        l1.insertFirst(1);
//        l2.insertFirst(4);
//        l2.insertFirst(3);
//        l2.insertFirst(1);
//        mergeTwoLists(l1, l2);

//        MyLinkedList my = new MyLinkedList();
//        my.addAtIndex(2,1);

        ListNode node0 = new ListNode(5);
        ListNode node1 = new ListNode(4, node0);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(1, node3);
//        ListNode node5 = new ListNode(5, node4);
//        ListNode node6 = new ListNode(1, node5);
//        ListNode node7 = new ListNode(5, node6);
//        ListNode node8 = new ListNode(5, node7);

         ListNode res = rotateRight(node4,2);
        System.out.println(res.next.next.val);

//        ListNode res = reverseBetween(node4, 2, 4   );
//        System.out.println(res.val);

//        reorderList(node);
//       ListNode temp = mergeSortLinkedList(node8);
//        System.out.println(temp.val);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        int size = 1;
        ListNode node = head;
        while (node != null && node.next != null){
            size++;
            node = node.next;
        }
        node.next = head;
        int travel = k % size;
        int len = size - travel;
        ListNode trav = head;
        for (int i = 0; i < len-1; i++) {
            trav = trav.next;
        }
        head = trav.next;
        trav.next = null;
        return head;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return  head;
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 1; curr != null && i < left ; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode last = prev;
        ListNode newEnd = curr;
        for (int i = left; curr != null && i <= right ; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (last != null) last.next = prev;
        else head = prev;
        newEnd.next = curr;
        return head;
    }

    public static  ListNode  mergeSortLinkedList(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;

       ListNode left = mergeSortLinkedList(node);
       ListNode right = mergeSortLinkedList(slow);
       return mergeThem(left, right);
    }

    private static ListNode mergeThem(ListNode head, ListNode next) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (head != null && next != null){
            if(head.val>next.val){
                temp.next = next;
                next = next.next;
                temp = temp.next;
            }else{
                temp.next = head;
                head = head.next;
                temp = temp.next;
            }
        }
        if (head != null){
            temp.next = head;
        }
        if (next != null){
            temp.next = next;
        }
        return node.next;
    }

    public static void reorderList(ListNode head) {
        ListNode next;
        ListNode node = head;
        ListNode reverse = null;
        ListNode res = new ListNode();
        ListNode temp = res;
        int size = 0;
        while(node != null && node.next != null){
            next = node.next;
            node.next = reverse;
            reverse = node;
            node = next;
            size++;
        }
        int count = 1;
        System.out.println(head.val);
        while(count<=size){
            if(count%2 != 0){
                next = head.next;
                head.next = null;
                temp.next = head;
                head = next;
            }else{
                next = reverse.next;
                reverse.next = null;
                temp.next = reverse;
                reverse = next;
            }
            count++;
            temp = temp.next;
        }
        head = res.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode node = temp;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if(l1!=null){
            node.next = l1;
        }
        if(l2!=null) {
            node.next = l2;
        }temp.display();
        return temp.next;
    }
}
