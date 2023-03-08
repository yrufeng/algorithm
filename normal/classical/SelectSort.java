package classical;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {1000, -1, 0, 8, 999, -100, 666};

        selectSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void selectSort(int[] arr) {
        if (arr.length > 1) {
            for (int i = 0; i < arr.length; i ++) {
                int min = i;
                for (int j = i + 1; j < arr.length; j ++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }

                if (min != i) {
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                }
            }
        }
    }
}
