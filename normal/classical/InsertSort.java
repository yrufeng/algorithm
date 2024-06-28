package classical;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 5, 2, 9, 7, 23, 56, 43, 99};

        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i ++) {
                int j = i - 1;
                int tmp = arr[i];
                while (j > 0 && arr[j] > tmp) {
                    arr[j+1] = tmp;
                    j --;
                }

                arr[j+1] = tmp;
            }
        }
    }
}
