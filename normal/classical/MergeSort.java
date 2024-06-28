package classical;

import java.util.Arrays;
import java.util.Stack;

/**
 * 归并排序
 * 1）稳定排序算法
 * 2）时间复杂度nlogn
 * 3）空间复杂度n
 * <a href="https://developer.aliyun.com/article/1282845">...</a>
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 2, 9, 7, 23, 56, 43, 99};

        System.out.println("排序前：" + Arrays.toString(arr));
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end)
            return;

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid, temp);

        mergeSort(arr, mid + 1, end, temp);

        merge(arr, start, mid, end, temp);
    }

    private static void merge(int[] arr, int startIdx, int midIdx, int endIdx, int[] temp) {
        int pre = startIdx, next = midIdx + 1, tempIdx = 0;

        while(pre <= midIdx && next <= endIdx) {
            if (arr[pre] <= arr[next]) {
                temp[tempIdx ++] = arr[pre ++];
            } else {
                temp[tempIdx ++] = arr[next ++];
            }
        }

        while(pre <= midIdx) {
            temp[tempIdx ++] = arr[pre ++];
        }

        while(next <= endIdx) {
            temp[tempIdx ++] = arr[next ++];
        }

        int i = 0;
        // attention：tempIdx && i + startIdx
        while (i < tempIdx) {
            arr[i + startIdx] = temp[i];
            i ++;
        }
    }
}
