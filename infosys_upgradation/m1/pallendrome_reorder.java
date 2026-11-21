package infosys_upgradation.m1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pallendrome_reorder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String st = br.readLine();
        int arr[] = new int[26];
        for (char c : st.toCharArray()) {
            arr[c - 'A']++;
        }
        int odd = 0;
        int oddIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
                oddIndex = i;
            }
        }
        if (odd > 1) {
            System.out.println("NO SOLUTION");
            return;
        }
        char ar[] = new char[st.length()];
        int s = 0, e = st.length() - 1;
        for (int i = 0; i < 26; i++) {
            while (arr[i] >= 2) {
                ar[s] = (char) ('A' + i);
                ar[e] = (char) ('A' + i);
                s++;
                e--;
                arr[i] -= 2;
            }
            if (arr[i] == 1) {
                ar[s] = (char) ('A' + i);
            }
        }
        System.out.println(new String(ar));
    }
}
