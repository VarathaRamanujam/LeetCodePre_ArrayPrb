package JavaPrograms;
class MyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public MyLinkedList() {

    }

    public Node getNode(int index){
        Node node = head;
        for(int i=1;i<=index;i++){
            node = node.next;
        }
        return node;
    }

    public int get(int index) {
        if(size-1 < index){
            return -1;
        }
        Node node = getNode(index);
        return node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if(tail == null){
            tail = node;
            head = node;
        }else{
            tail = getNode(size-1);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node temp = getNode(index-1);
        if(temp == null) return;
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(size-1 < index){
            return;
        }
        if (index == 0){
            deleteFirst();
            return;
        }
        Node node = getNode(index-1);
        node.next = node.next.next;
        size--;
    }

    public void deleteFirst(){
        head = head.next;
        if (head == null)tail = null;
        size--;
    }

    public void display(){
        Node node = head;
        while (node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node{
        private int val;
        private Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
