class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num: nums){
            if(hash.get(num) != null){
                return true;
            }
            hash.put(num, 1);
        } 
        return false;
    }
}
