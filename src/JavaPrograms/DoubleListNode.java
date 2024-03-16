package JavaPrograms;

public class DoubleListNode {
    public Node head;
    public Node tail;
    public int size;

    public void insertFirst(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void insertMiddle(int val, int index){
        Node temp = get(index);
        Node node = new Node(val);
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(tail == null) {
            tail=node;
            head=node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        head.prev = null;
        return val;
    }

    public int deleteLast(){
        Node node = get(size-1);
        int val = node.val;
        tail = node.prev;
        node.prev.next = null;
        return val;
    }

    public int deleteMiddle(int index){
        Node node = get(index+1);
        int val = node.val;
        node.prev = node.next;
        return val;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private static class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }
}
