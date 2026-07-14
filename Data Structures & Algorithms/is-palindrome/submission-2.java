class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true;

        StringBuilder cleanedString = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                cleanedString.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        s = cleanedString.toString();
        boolean isEven = (s.length() % 2 == 0);

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int mid = n / 2;

        for (int i = 0; i < mid; i++) {
            stack.push(s.charAt(i));
        }

        int start = (isEven) ? mid : mid + 1;

        for (int i = start; i < n; i++) {
            if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
