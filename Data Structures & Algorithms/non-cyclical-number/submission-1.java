class Solution {
    public boolean isHappy(int n) {
        String slow = Integer.toString(n);
        String fast = Integer.toString(sumOfSquares(slow));
    
        while(!slow.equals(fast)){
            fast = Integer.toString(sumOfSquares(fast));
            fast = Integer.toString(sumOfSquares(fast));
            slow = Integer.toString(sumOfSquares(slow));
        }

        return Integer.parseInt(fast) == 1;
    }

    public int sumOfSquares(String nStr){
        int count = 0;
        for(char c: nStr.toCharArray()){
            count += Math.pow(Character.getNumericValue(c), 2);
        }
        return count;
    }
}
