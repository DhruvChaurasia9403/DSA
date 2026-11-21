package infosys_upgradation.m1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class missing_number {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;
        for (int i = 0; i < n - 1; i++) {
            actualSum += Long.parseLong(st.nextToken());
        }
        System.out.println(expectedSum - actualSum);
    }
}
