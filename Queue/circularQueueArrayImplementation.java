package Queue;

public class circularQueueArrayImplementation {
    public static class cQueue{
        int size=0;
        int front = -1;
        int rare = -1;
        int arr[] = new int[10];
        void add(int val) throws Exception {
            if (size == 0) {
                front = rare = 0;
                arr[0] = val;
            } else if (size == arr.length) {
                throw new Exception("queue is full");
            } else if (rare == arr.length - 1) {
                rare = 0;
                arr[rare] = val;
            } else if (rare < arr.length-1) {
                arr[++rare] = val;
            }
            size++;
        }
        int remove() throws Exception{
            if(size==0){
                throw new Exception("queue is empty");
            }
            else {
                int val = arr[front];
                if (front == arr.length - 1) front = 0;
                else front++;
                size--;
                return val;
            }
        }
        int peek() throws Exception{
            if(size==0){
                throw new Exception("queue is empty");
            }
            else{
                return arr[front];
            }
        }
        int size(){
            return size;
        }
        void display() throws Exception{
            if(size==0){
                throw new Exception("queue is empty");
            }
            else if(size == arr.length){
                throw new Exception("queue is full");
            }
            else if(rare < front){
                for(int i = front;i<arr.length ; i++){
                    System.out.print(arr[i]+" ");
                }
                for(int i = 0 ; i <=rare ; i++){
                    System.out.print(arr[i]+" ");
                }
            }
            else{
                for(int i = front ; i<=rare ; i++){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        cQueue a = new cQueue();
        a.add(5);
        a.add(6);
        a.display();
        System.out.println(a.size());
        a.remove();
        a.display();
    }
}
