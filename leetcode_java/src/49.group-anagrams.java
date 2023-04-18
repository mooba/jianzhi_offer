import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToAnagrams = new HashMap<>(strs.length);
        
        for (String str : strs) {
            char[] charArr= str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            
            // keyToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(key);
            if (keyToAnagrams.get(key) == null) {
                List<String> list = new ArrayList<>();
                list.add(str);
                keyToAnagrams.put(key, list);
            } else {
                keyToAnagrams.get(key).add(str);
            }
        }

        return new ArrayList<>(keyToAnagrams.values());
    }
}
// @lc code=end

