package RecursionRevision;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(123456,(int)Math.log10(123456)));
    }
    public static int reverse(int n,int count){
        if(n%10==n){
            return n;
        }
        return n%10*(int)Math.pow(10,count)+reverse(n/10,count-1);
    }
}
