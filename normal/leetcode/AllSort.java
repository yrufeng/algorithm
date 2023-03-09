package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 */
public class AllSort {

    private static int totalNum = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        //int[] arr = {2, 3, 6, 7};

        allSort(arr, arr.length, 0);

        System.out.println("所有可能性：" + totalNum + "最终数组状态：" + Arrays.toString(arr));
    }

    public static void allSort(int[] arr, int length, int index) {
        if (index == length) {
            totalNum ++;
            System.out.println("可能性：" + totalNum + ": " + Arrays.toString(arr));
        }

        for (int i = index; i < length; i ++) {
            // 交换 下标 i && index
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;

            // 递归方式对剩下元素进行全排列
            allSort(arr, length, index+1);

            // 交换回 下标 i && index
            int temp2 = arr[i];
            arr[i] = arr[index];
            arr[index] = temp2;

        }
    }
}
