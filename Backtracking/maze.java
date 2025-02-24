package Backtracking;
import java.util.*;

public class maze {
    public static void main(String[] args) {
        System.out.println(countDirection("",3,3));
    }




    public static int count(int r , int c){
        if(r==1||c==1){
            return 1;
        }
        return count(r-1,c)+count(r,c-1);
    }



    public static void count(String p , int r , int c){
        if(r==1&&c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            count(p+'D',r-1,c);
        }
        if(c>1){
            count(p+'R',r,c-1);
        }
    }



    public static List<List<String>> countDirection(List<String> p , int r , int c){
        if(r==1&&c==1){
            List<List<String>> ls = new ArrayList<>();
            ls.add(new ArrayList<>(p));
            return ls;
        }
        List<List<String>> x = new ArrayList<>();
        if(r>1) {
            List<String> x1 = new ArrayList<>(p);
            x1.add(String.valueOf('D'));
            x.addAll(countDirection(x1,r-1,c));
        }

        if(c>1) {
            List x1 = new ArrayList<>(p);
            x1.add(String.valueOf('R'));
            x.addAll(countDirection(x1,r,c-1));
        }
        return x;
    }
    public static List<String> countDirection(String p , int r , int c){
        if(r==1&&c==1){
            List<String> ls = new ArrayList<>();
            ls.add(p);
            return ls;
        }
        List<String> x = new ArrayList<>();
        if(r>1) {
            x.addAll(countDirection(p+'D',r-1,c));
        }

        if(c>1) {
            x.addAll(countDirection(p+'R',r,c-1));
        }
        return x;
    }
}
