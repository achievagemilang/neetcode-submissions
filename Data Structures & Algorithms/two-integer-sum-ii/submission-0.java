class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while(true){
            int n1 = numbers[l];
            int n2 = numbers[r];

            if(n1 + n2 == target){
                return new int[]{l + 1, r + 1};
            } else if (n1 + n2 > target){
                r--;
            } else {
                l++;
            }
        }   
    }
}
