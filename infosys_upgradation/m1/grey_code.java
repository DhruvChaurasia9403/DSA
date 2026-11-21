package infosys_upgradation.m1;

import java.io.IOException;
import java.util.Scanner;
public class grey_code {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int total = 1 << x;
        for (int i = 0; i < total; i++) {
            int y = i ^ (i >> 1);
            String binary = Integer.toBinaryString(y);
            while (binary.length() < x) {
                binary = "0" + binary;
            }
            System.out.println(binary);
        }
    }
}