package infosys_upgradation.m1;

import java.util.Scanner;


public class wierd_algo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(n).append(" ");
            if (n == 1) break;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
        }
        System.out.println(sb);
    }
}

