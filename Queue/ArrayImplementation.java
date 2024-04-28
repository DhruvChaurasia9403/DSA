package Queue;

public class ArrayImplementation {
    public static void main(String[] args) {
        queue a = new queue();
        a.add(6);
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        a.display();
        a.remove();
        a.display();
        System.out.println(a.size);
    }
    public static class queue{
        int size = 0;
        int front = -1;
        int rare = -1;
        private int[] arr= new int[100];
        void add(int item){
            if(front == -1) front=rare=0;
            else {
                rare++;
            }
            arr[rare] = item;
            size++;
        }
        void remove(){
            if (size==0){
                System.out.println("queue is empty");
            }
            front++;
            size--;
        }
        int peek(){
            if(size==0){
                return -1;
            }
            return arr[front];
        }
        void display(){
            if (size==0){
                System.out.println("queue is empty");
                return;
            }
            for(int i=front ; i<=rare ; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
