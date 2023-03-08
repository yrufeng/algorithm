package classical;

import java.util.Arrays;

/**
 * 堆排序
 * https://blog.csdn.net/K346K346/article/details/50791102
 */
public class HeapSort {
    public static void main(String[] args) {
        int [] arr = {9, 12, 17, 30, 50, 20, 60, 65, 4, 49};

        heapSort(arr, arr.length);

        System.out.println("堆排序结果：" + Arrays.toString(arr));
    }


    private static void heapSort(int[] arr, int len) {
        //
        buildMinHeap(arr, len);

        for (int i = len-1; i > 0; i --) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            //
            minHeapFixDown(arr, i, 0);
        }
    }

    private static void buildMinHeap(int[] arr, int len) {
        int lastP = len/2 - 1;
        for (int i = lastP; i <= 0; i --) {
            minHeapFixDown(arr, len, i);
        }
    }

    private static void minHeapFixDown(int[] arr, int len, int idx) {
        if (idx > (len/2-1)) {
            return;
        }

        int tmp = arr[idx];
        int lastIdx = idx;
        while(idx <= len/2-1) {
            if (arr[2*idx+1] < tmp) {
                lastIdx = 2*idx+1;
            }

            if (2*idx+2 < len && arr[2*idx+2] < arr[2*idx+1] && arr[2*idx+2] < tmp) {
                lastIdx = 2*idx+2;
            }

            if (idx != lastIdx) {
                arr[idx] = arr[lastIdx];
                idx = lastIdx;
            } else break;
        }
        arr[lastIdx] = tmp;
    }
}
