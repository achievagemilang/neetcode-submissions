class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder generated = new StringBuilder();
        List<String> ans = new ArrayList<>();
        backtrack(0,0,n,generated, ans);
        return ans;
    }

    public void backtrack(int open, int close, int n, 
    StringBuilder generated, List<String> ans){
        if(open == close && open == n){
            ans.add(generated.toString());
            return;
        }

        if(open < n){
            generated.append('(');
            backtrack(open + 1, close, n, generated, ans);
            generated.deleteCharAt(generated.length() - 1);

        }

        if(close < open){
            generated.append(')');
            backtrack(open, close + 1, n, generated, ans);
            generated.deleteCharAt(generated.length() - 1);
        }
    }
}
