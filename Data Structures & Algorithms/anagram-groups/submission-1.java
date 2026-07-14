class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> mappedCountedArr = new HashMap<>();
        for(String s: strs){
            int[] count = new int[26]; 
            
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            String key = Arrays.toString(count);
            List<String> val = mappedCountedArr.getOrDefault(key, new ArrayList<>());
            val.add(s);
            System.out.println(key + " " + val);
            mappedCountedArr.put(key, val);
        }

        for(String key: mappedCountedArr.keySet()){
            ans.add(mappedCountedArr.get(key));
        }

        return ans;
    }
}
