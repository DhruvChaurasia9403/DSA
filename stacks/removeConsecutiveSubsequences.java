package stacks;

import java.util.*;

public class removeConsecutiveSubsequences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2};
        int[] ret = sub(arr);
        System.out.println(Arrays.toString(ret));
    }

    public static int[] sub(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] != stack.peek()) {
                stack.push(arr[i]);
            } else if (arr[i] == stack.peek()) {
                if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
                    stack.pop();
                }
            }
        }

        int size = stack.size();
        int[] ret = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ret[i] = stack.pop();
        }
        return ret;
    }
}
