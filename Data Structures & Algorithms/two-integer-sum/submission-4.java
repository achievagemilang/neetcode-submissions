class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            hashMap.put(nums[i], i);
        }

        int[] ans = new int[]{0, 0};
        int tmpIdx;
        int i = 0;
        for (int n: nums){
            int tmp = target - n;

            if (hashMap.get(tmp) != null){
                tmpIdx = hashMap.get(tmp);
                ans[0] = i;
                ans[1] = tmpIdx;
                if(ans[0] == ans[1]) {
                    i++;
                    continue;
                }
                break;
            }

            i++;
        }


        return ans;
    }
}

/*
    The idea:
    hash setiap kemunculan angka yang ada
    terus loop dari kiri ke kanan: sub target - now terus cari apakah ada occurence dari hasil lainnya?
    kalau ada itu jawaban kita pair aja dengan index tersebut
    kompleksitasnya O(n)
*/
