class Solution {
    public boolean isAnagram(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (char c : s.toCharArray()){
            mapS[c]++;
        }
        for (char c : t.toCharArray()){
            mapT[c]++;
        }

        return Arrays.equals(mapS,mapT);
    }
}
