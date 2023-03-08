package classical;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {100, -1, -10, 20, 10000, -3, 0, 8, 100, 8};

        //quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) { // 填充法
        if (left >= right) {
            return;
        }

        int low = left;
        int high = right;
        int mid = arr[left];

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
        if (left >= right) {
            return;
        }

        int low = left;
        int high = right;
        int mid = arr[left];

        while (low != high) {
            //
            while (low < high && arr[high] >= mid) {
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

        quickSort2(arr, left, low - 1);
        quickSort2(arr, low + 1, right);

    }
}
