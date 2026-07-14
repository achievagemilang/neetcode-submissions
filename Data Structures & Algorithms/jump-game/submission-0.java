class Solution {
    public boolean canJump(int[] nums) {
        int finish = nums.length - 1;

        for(int i=finish-1; i>=0; i--){
            if(i+nums[i] >= finish){
                finish = i;
            }
        }

        return finish == 0;
    }
}
