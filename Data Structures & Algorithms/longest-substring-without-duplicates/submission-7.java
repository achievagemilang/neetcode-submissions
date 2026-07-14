class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int maxCount = 0;
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (seen.contains(c)) {
                seen.remove(s.charAt(start));
                start++;
                count--;
            }

            seen.add(c);
            count++;
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
