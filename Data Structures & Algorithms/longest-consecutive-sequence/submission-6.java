class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int n: nums){
            numSet.add(n);
        }

        for(int n: numSet) {
                if(!numSet.contains(n - 1)){

                int length = 1;
                while(numSet.contains(n + length)){
                    length++;
                }

                res = Math.max(res, length);
            }
        }

        return res;
    }
}
