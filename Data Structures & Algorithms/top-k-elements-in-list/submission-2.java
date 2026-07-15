/*
Count occurences of all elements
Get top k map entry sorted by value -> can convert into priority queue using PairIntCount
*/
class Solution {
    public class Pair{
        int i;
        int count;
        Pair(int i, int count){
            this.i = i;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int n: nums){
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((s1, s2) -> s2.count - s1.count);
        for(Map.Entry<Integer, Integer> e: mp.entrySet()){
            Pair p = new Pair(e.getKey(), e.getValue());
            pq.add(p);
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll().i;
        }
        return res;
    }
}
