package classical;

import java.util.Arrays;

public class SortBubble {
    public static void main(String[] args) {
        int[] array = {1000, -1, 0, 8, 999, -100, 666};

        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }

    /**
     * key point
     * 1）排序前置调教 arr.length > 1
     * 2）外层循环边界，前n-1个元素都置换到自己位置后，最后一个元素不用置换 i < arr.length - 1
     * 3）提升效率，如果第i个元素 和 后续的 i+1 ~ arr.length - 1 都未发生置换说明i及后续都是已排好序的
     */

    public static void bubbleSort(int[] arr) {
        if (arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i ++) {
                boolean noSwap = true;
                for (int j = i + 1; j < arr.length; j ++) {
                    if (arr[i] > arr[j]) {
                        int tem = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tem;
                        noSwap = false;
                    }
                }
                if (noSwap) {
                    break;
                }
            }
        }
    }
}
