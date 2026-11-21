package infosys_upgradation.m1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class increasing_array {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        long x=0;
        for(int i = 0 ; i < n-1 ; i++){
            if(arr[i] > arr[i+1]){
                x += arr[i]-arr[i+1];
                arr[i + 1] = arr[i];
            }
        }
        System.out.println(x);
    }
}
