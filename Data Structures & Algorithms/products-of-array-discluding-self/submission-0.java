/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] postfix = new int[nums.length];
        int[] prefix = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(i == 0) prefix[i] = nums[i];
            else prefix[i] = prefix[i-1] * nums[i];
        }

        for(int i=nums.length-1; i >= 0; i--){
            if(i == nums.length-1) postfix[i] = nums[i];
            else postfix[i] = postfix[i+1] * nums[i];
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i == 0) ans[i] = postfix[i+1];
            else if(i == nums.length-1) ans[i] = prefix[i-1];
            else ans[i] = prefix[i-1] * postfix[i+1];
        }

        return ans;
    }
}
// @lc code=end

/*
 * The idea is simple: to use prefix + postfix product of the array
 * The ans of current idx will be the previous prefix * after postfix
 * 
 * TC: O(n) 
 */
