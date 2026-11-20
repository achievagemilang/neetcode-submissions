class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();
        
        for(String s: strs){
            int[] key = new int[26];
             
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                key[c - 'a']++;
            }
            String keyString = Arrays.toString(key);
            List<String> value = mp.getOrDefault(keyString, new ArrayList<>());
            value.add(s);

            mp.put(keyString, value);
        }

        for(String key: mp.keySet()){
            List<String> val = mp.get(key);
            ans.add(val);
        }
        
        return ans;
    }
}


/*
Anagram: exact same chars in another string 

Can be mapped: 
Count each chars -> str

How to get count of each chars within str?
- Loop: 
- Pick str 
- Count char: store it in a map when finished, count char becomes the key, value is str

T(n): O(n*m)
S(n): O(1)

*/
