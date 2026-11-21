package infosys_upgradation.m1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions_blood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int max = 0;
        int x = 1;
        for(int i = 0 ; i < st.length()-1 ; i++){
            if(st.charAt(i) == st.charAt(i+1)){
                x++;
            }
            else{
                max = Math.max(max,x);
                x=1;
            }
        }
        System.out.println(Math.max(max,x));
    }
}
