class Solution {
    class IntCount {
        int count;
        int val;

        IntCount(int val, int count){
            this.count = count;
            this.val = val;
        }
    }

public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<IntCount> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s2.count, s1.count));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new IntCount(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().val;
        }

        return result;
    }
}
