package hot100.slidingWindow;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串-中等
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args)
    {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }


    /**
     * 计算给定字符串中最长无重复字符子串的长度。
     *
     * @param s 输入的字符串
     * @return 最长无重复字符子串的长度
     */
    public static int lengthOfLongestSubstring(String s)
    {
        // 如果输入字符串为空或长度为0，则最长无重复字符子串的长度为0
        // 检查输入字符串是否为空
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 初始化最大长度为1，因为至少有一个字符的子串
        int maxLength = 1;
        // 当前无重复字符子串的长度
        int length = 0;
        // 将字符串转换为字符数组，方便处理
        char[] charArray = s.toCharArray();
        // 子串的起始索引
        int startIndex = 0;
        // 使用HashMap记录每个字符最近一次出现的索引，键为字符，值为索引
        HashMap<Character, Integer> hashMap = new HashMap<>();

        // 遍历字符数组
        for (int i = 0; i < charArray.length; i++) {
            // 如果当前字符已存在于HashMap中，说明遇到了重复字符
            if (hashMap.containsKey(charArray[i])) {
                // 获取重复字符的最近一次出现的索引
                Integer lastIndex = hashMap.get(charArray[i]);
                if (lastIndex >=  startIndex) {
                    // 更新起始索引
                    startIndex = lastIndex + 1;
                }
                // 更新当前无重复字符子串的长度
                length = i - startIndex + 1;
                // 更新重复字符的索引为当前索引
                hashMap.replace(charArray[i],i);
            } else {
                // 如果当前字符不存在于HashMap中，说明是新的字符
                // 更新当前无重复字符子串的长度
                length++;
                // 将当前字符及其索引加入HashMap
                hashMap.put(charArray[i],i);
            }
            // 更新最大长度
            maxLength = Math.max(maxLength, length);
        }
        // 返回最大长度
        return maxLength;
    }

}


