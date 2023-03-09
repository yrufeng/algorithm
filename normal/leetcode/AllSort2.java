package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllSort2 {

    private static List<List<Integer>> res = new LinkedList<>();
    private static Integer totalNum = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        //int[] arr = {2, 3, 6, 7};

        permute(arr);

        System.out.println("所有可能性：" + totalNum + "最终数组状态：" + Arrays.toString(arr));

        System.out.println("finally result: " + res);
    }

    private static List<List<Integer>> permute(int[] arr) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrace(arr, track);
        return res;
    }

    private static void backtrace(int[] arr, LinkedList<Integer> track) {
        if (arr.length == track.size()) {
            totalNum ++;
            res.add(new LinkedList<>(track));
            return;
        }

        for(int i = 0; i < arr.length; i ++) {
//            if (track.contains(arr[i])) {
//                continue;
//            }

            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }

            track.add(arr[i]);
            backtrace(arr, track);
            track.removeLast();
        }
    }
}
