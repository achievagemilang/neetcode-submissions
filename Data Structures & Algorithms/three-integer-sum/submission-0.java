class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int n1 = nums[i];

            int l = i+1;
            int r = nums.length - 1;

            while (l < r){
                int n2 = nums[l];
                int n3 = nums[r];

                if(n2 + n3 == target){
                    ans.add(Arrays.asList(n1,n2,n3));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (n2 + n3 > target){
                    r--;
                } else{
                    l++;
                }
            }
        }
        return ans;  
    }
}
