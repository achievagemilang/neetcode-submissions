class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 5];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i <= amount ; i++){
            for(int c: coins){
                if(i - c >= 0){
                    if(dp[i - c] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        } else return dp[amount];
    }
}
