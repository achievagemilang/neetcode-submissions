class Solution {
    public int maxProfit(int[] prices) {
       int l = 0;
       int r = prices.length;
       int max = 0;

       while(l < r){
        int buy = prices[l];
        for (int i=l+1; i<r; i++){
            int sell = prices[i];
            int diff = sell - buy;
            if(max < diff){
                max = diff;
            }     
        }
        l++;
       }
       return max;
    }
}
