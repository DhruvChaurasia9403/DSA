package stacks;

public class arrayImplemntation {
    public static class stack {
        private int n = 0;
        private int []arr = new int[10];
        void push(int item){
            arr[n] = item;
            n++;
        }
        int pop(){
            if(n==0){
                return 0;
            }
            int top = arr[n-1 ];
            arr[n-1]=0;
            n--;
            return top;
        }
        void peek(){
            System.out.println(arr[n-1]);
        }
        void display(){
            for(int i = 0 ; i < n ; i++){
                System.out.print(arr[i]+"    ");
            }
            System.out.println();
        }
        int size(){
            return n;
        }
        boolean isEmpty(){
            if(n==0){
                return true;
            }
            else return false;
        }
        boolean isFull(){
            if(n==arr.length) return true;
            return false;
        }
        int capacity(){
            return arr.length;
        }
    }
    public static void main(String[] args) {
        stack a = new stack();
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.display();
        a.pop();
        a.display();
    }
}
