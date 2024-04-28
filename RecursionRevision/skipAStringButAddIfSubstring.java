package RecursionRevision;

public class skipAStringButAddIfSubstring {
    public static void main(String[] args) {
        String a = "appapple akjhdlgfsjh apple apppapp";
        System.out.println(skip(a));
    }
//    public static String skip(String a){
//        if(a.isEmpty()) return "";
//        if(a.startsWith("app")){
//            if(a.startsWith("apple"))return "apple"+skip(a.substring(5));
//            else return skip(a.substring(3));
//        }
//        else return a.charAt(0)+a.substring(1);
//    }
    public static String skip(String a){
        if(a.isEmpty())return "";
        if(a.startsWith("app")&&!a.startsWith("apple")) return skip(a.substring(3));
        else return a.charAt(0)+skip(a.substring(1));
    }
}
