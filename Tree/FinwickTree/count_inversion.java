package Tree.FinwickTree;
import java.io.*;
import java.util.*;
import java.lang.Math;
public class count_inversion {

        static final long MOD = 1_000_000_007L;

        // Fenwick (Binary Indexed Tree)
        static class FenwickTree {
            int n;
            long[] tree;

            FenwickTree(int n) {
                this.n = n;
                this.tree = new long[n + 1];
            }

            void update(int i , int delta){
                while(i<=n){
                    tree[i] += delta;
                    i+= i&-i;
                }
            }
            long query(int i){
                long sum =0 ;
                while(i>=0 ){
                    sum += tree[i];
                    i -= i & -i;
                }
                return sum;
            }
        }

        public static int count_inversions(int n, int k, List<Integer> p) {

            if(k>n) return 0;
            FenwickTree leftBit = new FenwickTree(n);
            FenwickTree rightBit = new FenwickTree(n);

            long currentInversions = 0;

            long suffixInv = 0;
            for (int i = n - 1; i >= k; i--) {
                int val = p.get(i);
                suffixInv += rightBit.query(val - 1);
                rightBit.update(val, 1);
            }

            long min = suffixInv;
            currentInversions = suffixInv;

            for (int i = 0; i < n - k; i++) {
                int x = p.get(i);
                currentInversions += (i-leftBit.query(x));
                currentInversions += rightBit.query(x-1);
                leftBit.update(x,1);

                int y = p.get(i+k);
                currentInversions -= (i+1 - rightBit.query(y));
                rightBit.update(y,-1);
                currentInversions -= rightBit.query(y-1);

                min = Math.min(min,currentInversions);
            }

            return (int) (min % MOD);
        }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            int n = Integer.parseInt(scan.nextLine().trim());
            int k = Integer.parseInt(scan.nextLine().trim());

            List<Integer> p = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                p.add(Integer.parseInt(scan.nextLine().trim()));
            }

            int result = count_inversions(n, k, p);
            System.out.println(result);
        }
    }


