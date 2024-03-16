package JavaPrograms;


public class ListNode {
    public Node head;
    public Node tail;
    public int size;

    private class Node{
        private int val;
        private Node next;

        private Node(){
            size = 0;
        }
        private Node(int val) {
            this.val = val;
        }
        private Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(head.next == null)tail=head;
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if (tail == null) head = node;
        if(tail != null) tail.next = node;
        tail = node;
        size++;
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertMiddle(int val, int index){
        Node node = new Node(val);
        Node prev = get(index);
        node.next=prev.next;
        prev.next=node;
        size++;
    }

    public int deleteFirst(){
        int node = head.val;
        head = head.next;
        if(head == null)tail=null;
        size--;
        return node;
    }

    public int deleteLast(){
        Node temp = get(size-1);
        int node = temp.next.val;
        temp.next = null;
        size--;
        return node;
    }

    public int deleteMiddle(int index){
        Node temp = get(index);
        int node = temp.next.val;
        temp.next = temp.next.next;
        size--;
        return node;
    }

    public void display() {
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val+"  ");
            temp = temp.next;
        }
        System.out.println();
    }


    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty.");
        }

        this.val = values[0];
        ListNode current = this;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
    }
}
