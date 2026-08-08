class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return Math.max(robHelper(0, dp, nums), robHelper(1, dp, nums)); 
    }

    public int robHelper(int toRob, int[] dp, int[] nums){
        if(toRob >= nums.length) return 0;
        if(dp[toRob] != -1) return dp[toRob];

        int robThisPosition = nums[toRob] + robHelper(toRob+2, dp, nums);
        int skipToRobNextPosition = robHelper(toRob+1, dp, nums);

        dp[toRob] = Math.max(robThisPosition, skipToRobNextPosition);
        return dp[toRob];
    }
}
