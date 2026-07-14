class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        s = cleaned.toString();


        Stack<Character> st = new Stack<>();
        int pivot = s.length() / 2;
        boolean isEven = s.length() % 2 == 0;
        for (int i = 0; i < s.length(); i++){
            if(i < pivot){
                st.push(s.charAt(i));
            } else if (i == pivot){
                if (!isEven){
                    continue;
                }
                if(st.peek() == s.charAt(i)){
                    st.pop();
                } else {
                    return false;
                }
            } else if (i > pivot){
                if(st.peek() == s.charAt(i)){
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
// @lc code=end

/*
 * The idea is simple -> Use Stack
 * Loop through until pivot, until then push the elements;
 * Once you arrived at pivot, start popping
 * Pivot is n / 2
 * 
 * There are 2 conditions:
 * Even: n / 2 is the pivot 
 * Odd: n / 2 would be skipped, we start popping at (n / 2) + 1
 * 
 * TC: O(n)
 */
