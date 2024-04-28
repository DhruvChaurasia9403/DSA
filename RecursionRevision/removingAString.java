package RecursionRevision;

public class removingAString {
    public static void main(String[] args) {
        String q = "appleakjhsdfkjhdfappleakhjsk";
        System.out.println(remove(q));
    }
    public static String remove(String up){
        if(up.isEmpty())return "";
        if(up.startsWith("apple")) return remove(up.substring(5));
        else return up.charAt(0)+remove(up.substring(1));
    }
}
