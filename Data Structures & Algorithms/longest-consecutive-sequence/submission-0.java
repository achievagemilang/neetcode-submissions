class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int longestSequence = 1;

        HashSet<Integer> setNums = new HashSet<>();
        for(int n: nums){
            setNums.add(n);
        }

        for(int n : setNums){
            if(setNums.contains(n - 1)){
                continue;
            };
            if(setNums.contains(n + 1)){
                int longestSequenceTmp = 1;
                while(setNums.contains(n + 1)) {
                    longestSequenceTmp++;
                    n++;
                }
                longestSequence = Math.max(longestSequenceTmp, longestSequence);
            }
        }

        return longestSequence;
    }
}
