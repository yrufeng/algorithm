package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * lc_78
 * 题目给你输入一个无重复元素的数组nums，其中每个元素最多使用一次，请你返回nums的所有子集。
 */
public class SubSets {
    private static List<List<Integer>> res = new LinkedList<>();
    private static LinkedList<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println(subsets(arr));
        List<Character> test = new LinkedList<>();
        test.add('a');
        test.add('b');
        char[] chars = new char[test.size()];
        //int i = 0;
        for (int i = 0; i < test.size(); i ++) {
            chars[i] = test.get(i);
        }
        String str = String.valueOf(chars);
        Character[] t1 = new Character[10];
    }

    private static List<List<Integer>> subsets(int[] arr) {
        backTrack(arr, 0);
        return res;
    }

    private static void backTrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i ++) {
            track.addLast(nums[i]);
            backTrack(nums, i + 1);
            track.removeLast();
        }
    }
}
