class Solution {
    public boolean isPalindrome(String s) {
        s = s.replace(" ", "");
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        s = sb.toString();
        int l = 0,r = s.length()-1;

        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;

    }
}
