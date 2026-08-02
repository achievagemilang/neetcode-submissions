class Solution {
    public int trap(int[] height) {
        if(height.length == 1) return 0;
        int ans = 0;
        int tilesInBetween = 0;

        int l = 0;
        for(int r = 1; r < height.length; r++){
            if(height[l] <= height[r]){
                int currentArea = Math.min(height[r], height[l]) * (r - l - 1);
                ans = ans + currentArea - tilesInBetween;
                currentArea = 0;
                tilesInBetween = 0;
                l = r;
                continue;
            }

            tilesInBetween += height[r];
        }

        int leftMax = l;
        int r = height.length - 1;
        tilesInBetween = 0;
        for(l = height.length - 2; l >= leftMax; l--){
            if(height[r] <= height[l]){
                int currentArea = Math.min(height[r], height[l]) * (r - l - 1);
                ans = ans + currentArea - tilesInBetween;
                currentArea = 0;
                tilesInBetween = 0;
                r = l;
                continue;
            }

            tilesInBetween += height[l];
        }

        return ans;
    }
}
