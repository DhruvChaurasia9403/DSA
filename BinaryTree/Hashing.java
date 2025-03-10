package BinaryTree;
import java.util.*;

import java.util.Arrays;

public class Hashing {
    public static void main(String[] args) {
//        String s = "abcddacbaby(*&$(*&(@";
        int[] arr = {1,2,3,32,2,1,132,412,3,1,2,3,4,3,213,2,3,23,1,2};
        HashMap<Integer,Integer> map = countFrequency(arr);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
    public static HashMap<Integer,Integer> countFrequency(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return map;
    }
    public static void charaterCount(String s){
        int [] hash = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            hash[(int)ch]+=1;
        }
        System.out.println(Arrays.toString(hash));
    }
}
