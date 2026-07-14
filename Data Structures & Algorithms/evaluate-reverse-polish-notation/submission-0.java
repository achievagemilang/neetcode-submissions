class Solution {
public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        Set<String> operSet = Set.of("+", "-", "/", "*");

        for (String token : tokens) {
            if (operSet.contains(token)) {
                int n2 = stack.pop(); 
                int n1 = stack.pop(); 
                
                int res = doCalc(n1, n2, token);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }

    Integer doCalc(int n1, int n2, String oper){
        Integer res = 0;
        switch (oper){
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
        }
        return res;
    }
}
