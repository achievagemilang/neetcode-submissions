class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int r = 0, l = 0;

        int maxLen = 0;
        while(r < s.length()){
            Character c = s.charAt(r);

            if(mp.containsKey(c)){
                l = Math.max(l, mp.get(c) + 1);
            } 

            mp.put(c, r);
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
