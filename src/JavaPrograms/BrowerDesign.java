package JavaPrograms;

public class BrowerDesign {

        public BrowerDesign(String homepage) {
            Node node = new Node(homepage);
            head = node;
            tail = node;
            current = node;
        }

        public void visit(String url) {
            Node node = new Node(url);
            if(head == null) {
                BrowerDesign obj = new BrowerDesign(url);
                return;
            }
            Node curr = current;
            curr.next = node;
            node.prev = curr;
            tail = node;
            current = node;
        }

        public String back(int steps) {
            Node curr = current;
            for(int i=1; curr.prev != null && i<=steps; i++){
                curr = curr.prev;
            }
            current = curr;
            return curr.url;
        }

        public String forward(int steps) {
            Node curr = current;
            for(int i=1; curr.next != null && i<=steps; i++){
                curr = curr.next;
            }
            current = curr;
            return curr.url;
        }

        public Node head;
        public Node tail;
        public Node current;
        private static class Node{
            private String url;
            private Node next;
            private Node prev;

            Node(String url){
                this.url = url;
                this.next = null;
                this.prev = null;
            }
        }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}

class Output {
    public static void main(String[] args) {
        BrowerDesign browserHistory = new BrowerDesign("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}