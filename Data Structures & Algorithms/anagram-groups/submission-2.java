class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String s: strs){
            int[] countArr = new int[26];
            for(char c: s.toCharArray()){
                countArr[c - 'a']++;
            }

            String key = Arrays.toString(countArr);
            List<String> value = mp.getOrDefault(key, new ArrayList<>());
            value.add(s);
            mp.put(key, value);
        }

        return new ArrayList<>(mp.values());
    }
}

/*
Map:
countArray -> List["act", "cat"]


ret:
List<List<String>> 

*/
