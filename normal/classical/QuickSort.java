package classical;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 交换排序
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {100, -1, -10, 20, 10000, -3, 0, 8, 100, 8};
        System.out.println(Arrays.toString(arr));

        //quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) { // 填充法
        if (left >= right) return;

        int low = left, high = right, mid = arr[left];
        while (low != high) {
            while (low < high && arr[high] >= mid) {
                high --;
            }
            arr[low] = arr[high];
            //
            while (low < high && arr[low] <= mid) {
                low ++;
            }
            arr[high] = arr[low];
        }

        arr[low] = mid;

        quickSort(arr, left, low - 1);
        quickSort(arr, low + 1, high);
    }

    public static void quickSort2(int[] arr, int left, int right) { // 交换法
        if (left >= right) return;

        int low = left, high = right, mid = arr[left];
//int[] arr = {100, -1, -10, 20, 10000, -3, 0, 8, 100, 8};
//int[] arr = {100, -1, 8, 20, 10000, -3, 0, 8, 100, -10};
//int[] arr = {100, -1, 8, -10, 10000, -3, 0, 8, 100, 20};
//int[] arr = {100, -1, 8, -10, 20, -3, 0, 8, 100, 10000};
//int[] arr = {100, -1, 8, -10, 20, -3, 0, 100, 8(low and high), 10000};
        while (low != high) {
            while (low < high && arr[high] > mid) {
                high --;
            }
            while (low < high && arr[low] <= mid) {
                low ++;
            }
            // swap
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }
        // swap
        int temp = arr[low];
        arr[low] = arr[left];
        arr[left] = temp;
// 第一轮 100到指定位置
//int[] arr = {100, -1, 8, -10, 20, -3, 0, 100, 8(low and high), 10000};
//int[] arr = {8, -1, 8, -10, 20, -3, 0, 100, 100, 10000};
        quickSort2(arr, left, low - 1);
        quickSort2(arr, low + 1, right);
    }
}
