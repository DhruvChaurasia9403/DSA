package RecursionRevision;

public class removingALetter {
    public static void main(String[] args) {
        String a = "asdjkfakjhkfjahk";
        remove("", a);
    }
    public static void remove(String p , String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch=='a'){
            remove(p,up.substring(1));
            //subString method returns the string after removing all the starting elements it was
            //asked to remove.
        }
        else{
            remove(p+ch,up.substring(1));
        }
    }
}
