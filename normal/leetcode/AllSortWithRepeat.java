package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列：元素可重复版
 * https://leetcode.cn/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
 */

public class AllSortWithRepeat {

    private static List<List<Integer>> res = new LinkedList<>();
    private static List<Integer> track = new ArrayList<>();
    private static Integer totalNum = 0;

    private static boolean[] vis;

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        //int[] arr = {2, 3, 6, 7};

        Arrays.sort(arr);
        vis = new boolean[arr.length];

        permute(arr);

        System.out.println("所有可能性：" + totalNum + "最终数组状态：" + Arrays.toString(arr));

        System.out.println("finally result: " + res);
    }

    private static List<List<Integer>> permute(int[] arr) {
        backtrace(arr, 0);
        return res;
    }

    private static void backtrace(int[] arr, int idx) {
        if (arr.length == idx) {
            totalNum ++;
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < arr.length; i ++) {
            if (vis[i] || (i > 0 && arr[i - 1] == arr[i] && !vis[i - 1])) {
                continue;
            }
            track.add(arr[i]);
            vis[i] = true;
            backtrace(arr, idx + 1);
            vis[i] = false;
            track.remove(idx);
        }
    }
}
