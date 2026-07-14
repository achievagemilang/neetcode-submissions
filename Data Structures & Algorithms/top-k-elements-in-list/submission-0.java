class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = entriesSortedByValues(hash);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = entries.get(i).getKey();
        }
        
        return ans;
    }

    static <K, V extends Comparable<? super V>> 
        List<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        
        List<Map.Entry<K, V>> sortedEntries = new ArrayList<>(map.entrySet());

        Collections.sort(sortedEntries, 
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortedEntries;
    }
}
