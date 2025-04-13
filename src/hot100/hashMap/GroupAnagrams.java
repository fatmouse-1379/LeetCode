package hot100.hashMap;

import java.util.*;

/**
 * 049. 字母异位次分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 20240720
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, String> responseMap = new HashMap<>();
        HashMap<String, List<String>> wordMap = new HashMap<>();
        for(String str:strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String keyStr = new String(ca);
            if (!wordMap.containsKey(keyStr)) {
                wordMap.put(keyStr, new ArrayList<>());
            }
            wordMap.get(keyStr).add(str);
        }
        return new ArrayList<>(wordMap.values());

    }
}
