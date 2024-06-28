package hot;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 */

public class AALengthOfLongestSubString {
    public static void main(String[] args) {
        String str = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        String str4 = " ";
        String str5 = "dvdf";

        int longestSubString = lengthOfLongestSubString("aab");

        System.out.println("不重复最长字串长度: " + longestSubString);
    }

    private static int lengthOfLongestSubString(String str) {
        int maxLen = 0;
        if (str.length() > 0) {
            char[] strChars = str.toCharArray();
            int currLen = 0;
            Map<Character, Integer> chatMap = new HashMap<>();
            for (int i = 0; i < strChars.length; i ++) {
                if (!chatMap.containsKey(strChars[i])) {
                    currLen += 1;
                    chatMap.put(strChars[i], i);
                } else {
                    i = i > 0 && strChars[i] == strChars[i-1] ? i-1 : chatMap.get(strChars[i]);
                    currLen = 0;
                    chatMap.clear();
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}
