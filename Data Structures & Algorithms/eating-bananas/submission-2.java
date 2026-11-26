class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int p: piles){
            r = Math.max(p, r);
        } 
        int ans = r;

        while(l <= r){
            int m = (l + r) / 2;
            
            long speed = 0;
            for(int p: piles){
                speed += Math.ceil((double) p / m);
            }

            if(speed <= (long) h){
                ans = Math.min(ans, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}
