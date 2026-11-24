class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            int m = target - n;
            if(mp.containsKey(m)){
                return new int[]{mp.get(m), i};
            }
            mp.put(n, i);
        }

        return new int[]{0, 0};
    }
}
