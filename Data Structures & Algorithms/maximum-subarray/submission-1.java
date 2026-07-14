class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = -1;
        int currentMax = 0;

        for (int num: nums){
            if (currentMax < 0) currentMax = 0;
            currentMax += num;

            if (globalMax < currentMax){
                globalMax = currentMax;
            }
        }
        return globalMax;
    }
}
