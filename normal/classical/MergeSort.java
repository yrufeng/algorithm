package classical;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 2, 9, 7, 23, 56, 43, 99};

        System.out.println("排序前：" + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);

        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int startIdx, int midIdx, int endIdx) {
        int[] temp = new int[arr.length];
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
