package JavaPrograms;

public class ListNode {
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
