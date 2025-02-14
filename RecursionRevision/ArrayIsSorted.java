package RecursionRevision;

public class ArrayIsSorted {
    public static void main(String[] args) {
        int []arr = {1,2,5,742,4,6,57};
        System.out.println(sorted(arr,1));
    }
    public static Boolean sorted(int[] arr , int index){
        if(index==arr.length) return true;
        return arr[index]>=arr[index-1]&&sorted(arr,index+1);
    }
}
