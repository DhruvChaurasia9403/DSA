public class reverseWordsInString151 {
    //https://leetcode.com/problems/reverse-words-in-a-string/submissions/1221376001/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        String a = "welcome to this  world ";
        String arr[] = a.split(" +");
        String o = "";
        for(int i = arr.length-1 ; i>=0 ; i--){
            o+=arr[i] +" ";
        }
        System.out.println(o.trim());
    }
}
