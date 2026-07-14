class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int currentSumMax = 0;
    
        for (int num : nums){
            if (currentSumMax < 0){
                currentSumMax = 0;
            } 
            currentSumMax += num;

            globalMax = Math.max(currentSumMax, globalMax);
        }

        return globalMax;
    }
}
