public class slidingWindowSubArrayLessThanK {
    public static void main(String[] args) {
        int []nums = {10,5,2,6};
        int k = 100;
        int left = 0;
        int right = 0;
        int count = 0;
        int product =1;
        while(right<nums.length){
            product = product*nums[right];
            right = right+1;
            while(left<right&&k<=product){
                product = product/nums[left];
                left++;
            }
            if(k>product){
                count+= right-left;
            }
        }
        System.out.println(count);
    }
}
