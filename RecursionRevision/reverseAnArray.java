package RecursionRevision;

public class reverseAnArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int arr2[] = func(arr,0);
        for (int i = 0 ; i< arr.length ; i++){
            System.out.println(arr2[i]);
        }
    }
    public static int[] func(int []arr , int index){
        if(index == arr.length/2){
            return arr;
        }
        int temp = arr[index];
        arr[index] = arr[arr.length - index-1];
        arr[arr.length-index-1] = temp;
        return func(arr,index+1);
    }
}
