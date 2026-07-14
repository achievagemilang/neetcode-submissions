class Solution {
    public boolean isHappy(int n) {
        String nStr = Integer.toString(n);
        HashSet<Integer> seen = new HashSet<>();
        while(true){
            int count = 0;
            for(char c: nStr.toCharArray()){
                count += Math.pow(Character.getNumericValue(c), 2);
            }

            if(seen.contains(count)){
                break;
            }

            if(count == 1){
                return true;
            } else{
                seen.add(count);
                nStr = Integer.toString(count);
            }
        }
        return false;
    }
}
