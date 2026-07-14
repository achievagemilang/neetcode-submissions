class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];
        int r, l;
        r = l = 0;

        int maxLen = 0;
        int maxFreq = 0;

        while (r < s.length()){
            Character c = s.charAt(r);
            freqArr[c - 'A']++;

            maxFreq = Math.max(maxFreq, freqArr[c - 'A']);

            while (r - l + 1 - maxFreq > k){
                freqArr[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}