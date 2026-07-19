class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            int l = i+1;
            int r = nums.length-1;

            while(l < r){
                if(-nums[i] == nums[l] + nums[r]){
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }

                } else if(nums[l] + nums[r] < -nums[i] ){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
