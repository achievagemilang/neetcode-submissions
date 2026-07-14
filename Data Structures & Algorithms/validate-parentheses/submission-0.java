/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start


class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop(); 
                if ((c == '}' && top != '{') ||
                    (c == ')' && top != '(') ||
                    (c == ']' && top != '[')) {
                    return false; 
                }
            }
        }

        return st.isEmpty();
    }
}
// @lc code=end

/*
 * 1. The idea is to use stack
 * 2. If it uses an open bracket the push it in the stack
 * 3. If it is a closing bracket then pop our stack.
 * 4. If the pop element not the same in the open bracket at top, return false.
 * 5. If the stack is empty in the end, return true.
 * 
 * TC: O(n)
 */
