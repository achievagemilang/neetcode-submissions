class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        int[] flagged = new int[10000];

        for(int i = 0; i < strs.length; i++){
            if(flagged[i] != 0) continue;
            List<String> group = new ArrayList<>();
            String sen1 = strs[i];
            int[] hash1 = new int[26];
            group.add(sen1);
            flagged[i] = 1;
            for(int j = 0; j < sen1.length(); j++){
                hash1[sen1.charAt(j) - 'a']++;
            }
            for(int j = strs.length - 1; j > i; j--){
                String sen2 = strs[j];
                int[] hash2 = new int[26];
                if(sen1.length() != sen2.length()) continue;

                for(int k = 0; k < sen2.length(); k++){
                    hash2[sen2.charAt(k) - 'a']++;
                }

                if(Arrays.equals(hash1, hash2)){
                    group.add(sen2);
                    flagged[j] = 1;
                }
            }
            ans.add(group);
        }

        return ans;
        
    }

}
