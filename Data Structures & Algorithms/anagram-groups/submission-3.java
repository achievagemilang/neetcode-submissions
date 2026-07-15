/*
1. Make loop
2. for iter 1, get s convert into char[26] -> Make as key of string
3. For the key string create arraylist and append s into it
4. Loop until all s in strs
5. List all possible by creating res, and loop through all keys in the map  
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();
        
        for(String s: strs){
            int[] count = new int[26];
            for(Character c: s.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            List<String> val =  mp.getOrDefault(key, new ArrayList<>());
            val.add(s);
            mp.put(key, val);
        }

        for(String key: mp.keySet()){
            res.add(mp.get(key));
        }

        return res;
    }
}
