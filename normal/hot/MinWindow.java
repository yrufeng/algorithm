package hot;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */

public class MinWindow {
    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "aa";

        String subStr = minWindow(str1, str2);

        System.out.println(subStr);
    }

    private static String minWindow(String str1, String str2) {
        int llen = str1.length(), rlen = str2.length();

        if (llen < rlen) {
            return "";
        }

        // 构造需要的数据结构
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        // 双指针 形成滑动窗口
        int left = 0, right = 0;
        // 记录最短子串长度
        int len = Integer.MAX_VALUE;
        // 记录起始下标
        int start = 0;
        // 记录窗口中数据是否满足条件
        int bingo = 0;

        for (int i = 0; i < str2.length(); i ++) {
            char c = str2.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < str1.length()) {//ADOBECODEBANC
            char c = str1.charAt(right);
            // 窗口右移
            right ++;
            // 窗口右移数据处理
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 当窗口内字符及出现次数 都满足待比较字符串条件 则bingo+1，bingo与待比较字符串长度相同时 则满足条件
                if (need.get(c).equals(window.get(c))) {
                    bingo ++;
                }
            }

            // 窗口缩小 及 数据处理
            // 注意这里条件是need.size，开始写成了str2.length()，重复字符的case过不了
            while (bingo == need.size()) {
                int temp = right - left;
                if (temp < len) {
                    start = left;
                    len = temp;
                }

                char d = str1.charAt(left);
                left ++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        bingo -= 1;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        // 注意substring函数两个参数是起始坐标, 开始使用了(start, len) 调试半天
        return len == Integer.MAX_VALUE ? "" : str1.substring(start, start+len);
    }
}
