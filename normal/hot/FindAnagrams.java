package hot;

import java.util.*;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示:
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 */

public class FindAnagrams {
    public static void main(String[] args) {
        String str1 = "abab";
        String str2 = "ab";

        List<Integer> pos = findAnagrams2(str1, str2);

        System.out.println(pos);
    }

    private static List<Integer> findAnagrams(String str1, String str2) {
        List<Integer> res = new ArrayList<>();
        // 定义期望形态数据结构供比较 定义滑动窗口数据结构已在遍历过程中构造数据结构 对比是否满足
        Map<Character, Integer> need = new HashMap<>(), windows = new HashMap<>();
        // 转化为待对比的数据结构
        for (int i = 0; i < str2.length(); i ++) {
            need.put(str2.charAt(i), need.getOrDefault(str2.charAt(i), 0) + 1);
        }

        // 双指针 控制滑动窗口
        int left = 0, right = 0;
        // 定义计数器 记录窗口中满足need中条件的字符个数
        int bingo = 0;
        while (right < str1.length()) {
            char c = str1.charAt(right);

            // think about why not all char add in window
            // 滑入窗口 数据处理
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(windows.get(c))) {
                    bingo += 1;
                }
            }
            // 维护窗口长度
            if (right - left == str2.length()) {
                char e = str1.charAt(left);
                left ++;
                if (need.containsKey(e)) {
                    // think about why need this condition not reduce directly
                    if (windows.get(e).equals(need.get(e))) {
                        bingo -= 1;
                    }

                    if (windows.get(e) > 1) {
                        windows.put(e, windows.get(e) - 1);
                    } else {
                        windows.remove(e);
                    }
                }
            }
            right ++; // 窗口右滑

            // 滑出窗口 数据处理
            while (bingo == need.size()) {
                res.add(left);

                char d = str1.charAt(left);
                left ++;

                if (need.containsKey(d)) {
                    // think about why need this condition not reduce directly
                    if (windows.get(d).equals(need.get(d))) {
                        bingo -= 1;
                    }

                    if (windows.get(d) > 1) {
                        windows.put(d, windows.get(d) - 1);
                    } else {
                        windows.remove(d);
                    }
                }
            }
        }

        return res;
    }

    private static List<Integer> findAnagrams2(String left, String right) {
        List<Integer> res = new ArrayList<>();

        int llen = left.length(), rlen = right.length();
        if (llen < rlen) {
            return res;
        }

        // 定义两个数组，记录字符及出现个数
        int[] leftArr = new int[26], rightArr = new int[26];
        for (int i = 0; i < right.length(); i ++) {
            leftArr[left.charAt(i) - 'a'] += 1;
            rightArr[right.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(leftArr, rightArr)) {
            res.add(0);
        }

        // ? cbaebabacd abc
        // 控制窗口大小，隐晦
        for (int i = 0; i < llen - rlen; i ++) {
            leftArr[left.charAt(i) - 'a'] -= 1;
            leftArr[left.charAt(i + rlen) - 'a'] += 1;

            if (Arrays.equals(leftArr, rightArr)) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
