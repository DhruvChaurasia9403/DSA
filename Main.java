
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e =0,max=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(e<x){
            int a = arr[e];
            if(!map.containsKey(a)){
                map.put(a,e);
                max= Math.max(max,map.size());
                e++;
            }else {
                map.remove(arr[s]);
                s++;
            }
        }
        System.out.println(max);
    }
}
