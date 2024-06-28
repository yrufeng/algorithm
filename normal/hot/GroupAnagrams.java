package hot;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};

        List<List<String>> res = findRes(strs2);

        System.out.println(res);

        Set<String> conv1 = new TreeSet<>();
        for (int i = 0; i < strs2[0].length(); i ++) {
            conv1.add(String.valueOf(strs2[0].charAt(i)));
        }

        Set<String> conv2 = new TreeSet<>();
        for (int i = 0; i < strs2[1].length(); i ++) {
            conv2.add(String.valueOf(strs2[1].charAt(i)));
        }
        System.out.println(conv1);
        System.out.println(conv2);
        System.out.println(conv1.equals(conv2));
    }

    private static List<List<String>> findRes(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length > 0) {
            if (strs.length == 1) {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[0]);
                res.add(tmp);
            } else {
                Map<String, List<String>> temp = new HashMap<>();
                for (int i = 0; i < strs.length; i ++) {
                    String chgStr = sortStr(strs[i]);
                    if (temp.containsKey(chgStr)) {
                        temp.get(chgStr).add(strs[i]);
                    } else {
                        temp.put(chgStr, new ArrayList<>(Arrays.asList(strs[i])));
                    }
                }
//                for (List<String> it : temp.values()) {
//                    res.add(it);
//                }
                Iterator<Map.Entry<String, List<String>>> entry = temp.entrySet().iterator();
                while (entry.hasNext()) {
                    Map.Entry<String, List<String>> tmp = entry.next();
                    res.add(tmp.getValue());
                }
            }
        }


        return res;
    }

    private static String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private static List<List<String>> findRes2(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        res = new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values());

        return res;
    }
}
