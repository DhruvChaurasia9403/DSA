package Sorting;

public class InsertionSort {
    public static void main(String[] args) {

    }
    public static int[] Insertion(int[] arr){
        for(int i = 1 ; i < arr.length ; i++){
            int x = arr[i];
            int j = i-1;
            while(j<=0&&arr[j]>x){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1] = x;
        }
        return arr;
    }
}
