class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> mp = new HashMap<>();
       for (int i = 0; i < nums.length; i++){
         int n = nums[i];
         int q = target - n;
         if (mp.containsKey(q)){
            return new int[]{mp.get(q),i};
         }
         mp.put(n, i);
       } 
       return new int[]{0, 0};
    }
}
