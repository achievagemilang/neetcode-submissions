class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i : piles){
            if(max < i){
                max = i;
            }
        }
        int l = 1;
        int r = max;

        int ans = r;
        while (l <= r){
            int m = (l + r)/2;

            int curHours = 0;
            for (int i: piles){
                curHours += Math.ceil((double)i / m);
            }

            if (curHours > h){
                l = m + 1;
            } else {
                r = m - 1;
                ans = m;
            }
        }
        return ans;
    }
}
