package hot100.dynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 确定边界条件
        if (s == null || s.length() == 0 || wordDict == null|| wordDict.size() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.size() > 0) {
                    String sub = s.substring(j, i);
                    for (String word : wordDict) {
                        if (word.equals(sub)) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[n];
    }
}
