class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;

            String s = str.substring(i, i + len);
            ans.add(s);

            i += len;
        }

        return ans;
    }
}
/*
The idea is simple: we encode it like this:
"<length>#<str>" iterate for each str in strs

That way we provide consistent format and can decode it back easily in O(n)
*/
