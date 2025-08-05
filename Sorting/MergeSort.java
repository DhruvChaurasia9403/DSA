package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {38, 27, 43, 10};

        partition(arr, 0, arr.length - 1);

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void partition(int[] arr,int l , int r){
        if(l<r){
            int m = l+(r-l)/2;
            partition(arr , l , m);
            partition(arr , m+1 , r);
            merge(arr , l , m , r);
        }
    }
    public static void merge(int[] arr , int l , int m , int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1 ; i++){
            L[i] = arr[l+i];
        }
        for(int i = 0 ; i < n2 ; i++){
            R[i] = arr[m+1+i];
        }
        int i = 0 , j = 0 , k = l;
        while(i<n1 && j<n2){
            if(L[i]>R[j]){
                arr[k] = R[j];
                j++;
            }
            else {
                arr[k] = L[i];
                i++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
