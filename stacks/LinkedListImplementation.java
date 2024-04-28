package stacks;

public class LinkedListImplementation {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public static class stack{
        int n = 0;
        ListNode head = null;
        void push (int val) {
        ListNode item = new ListNode(val);
        item.next = head;
        n++;
        head = item;
        }
        int size(){
            return n;
        }
        int pop(){
            if(head==null) {
                System.out.println("stack unerflow");
            }
            ListNode temp = head;
            head = head.next;
            return temp.val;
        }
        void display(){
            ListNode temp = head;
            while(temp!=null){
                System.out.print(temp.val+"     ");
                temp=temp.next;
            }
            System.out.println();
        }
        int peek(){
            return head.val;
        }
        void displayRev(ListNode node) {
            if (node == null)
                return;
            displayRev(node.next);
            System.out.print(node.val + " ");
        }

        void displayReverse() {
            displayRev(head);
            System.out.println();
        }

    }
    public static void main(String[] args) {
        stack a = new stack();
        a.push(5);
        a.push(4);
        a.push(3);
        a.push(2);
        a.push(1);
        a.display();
        a.pop();
        a.display();
        System.out.println(a.peek());
        a.displayReverse();
    }
}
