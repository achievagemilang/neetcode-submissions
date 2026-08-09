class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        
        return f(coins, amount, new int[amount + 1]);
    }
    
private int f(int[] coins, int rem, int[] dp) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        
        if (dp[rem] != 0) return dp[rem];

        int min = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            int res = f(coins, rem - coin, dp);
            
            if (res >= 0 && res < min) {
                min = 1 + res; 
            }
        }

        dp[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        
        return dp[rem];
    }
}
