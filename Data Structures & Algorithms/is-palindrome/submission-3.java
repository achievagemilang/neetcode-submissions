class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleanedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                cleanedString.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        String cleaned = cleanedString.toString();
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
