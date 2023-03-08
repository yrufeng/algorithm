package classical;

public class SortBubble {
    public static void main(String[] args) {
        String key = "yrf";
        int h;
        h = key.hashCode();
        System.out.println(h ^ (h >>> 16));
        System.out.println(h);
        System.out.println(h >>> 16);

        int[] array = {1000, -1, 0, 8, 999, -100, 666};

        bubbleSort(array);

        for (int i = 0; i < array.length; i ++) {
            System.out.print(array[i] + " ");
            //System.out.print("下标：" + i + "对应值：" + array[i]);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr.length > 1) {
            for (int i = 0; i < arr.length -1; i ++) {
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
