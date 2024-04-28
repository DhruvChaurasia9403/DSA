package Queue;

public class linkedListImplementation {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static class queue{
        private int size = 0;
        ListNode head = null;
        ListNode tail = null;
        public void add(int val){
            ListNode temp = new ListNode(val);
            if(size==0){
                head = temp;
                tail = temp;
            }
            else{
                tail.next = temp;
                tail=temp;
            }
            size++;
        }
        public void remove(){
            if (head != tail ) {
                head = head.next;
                size--;
            }
            else System.out.println("This is empty");
        }
        public void display(){
            ListNode temp = head;
            while(temp!=null){
                System.out.print(temp.val);
                temp=temp.next;
            }
            System.out.println();
        }
        public int peek(){
            if (head != null)
                return head.val;
            else {
                System.out.println("Queue is empty");
                return -1;
            }
        }
        public int size(){
            return size;
        }
    }

    public static void main(String[] args) {
        queue a = new queue();
        a.add(5);
        a.display();
    }
}
