import java.util.*;
public class Solution {

    private String getKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new LinkedList<List<String>>();
        if (strs == null || strs.length == 0) {
            return ret;
        }
        Map<String, List<String>> all = new HashMap<String, List<String>>();

        String key = null;
        List<String> anagrams = null;
        for (String str : strs) {
            key = getKey(str);

            anagrams = all.get(key);
            if (anagrams == null) {
                anagrams = new LinkedList<String>();
                all.put(key, anagrams);
            }

            anagrams.add(str);
        }

        ret.addAll(all.values());

        return ret;
    }
}