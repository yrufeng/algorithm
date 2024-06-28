package classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 堆排序
 * 1）不稳定排序
 * 2）时间复杂度nlogn
 * https://developer.aliyun.com/article/1046883
 * 上面的adjustHeap方法有问题，参考下面的
 * https://www.cnblogs.com/luomeng/p/10618709.html
 *
 * https://blog.csdn.net/K346K346/article/details/50791102
 */
public class HeapSort {
    public static void main(String[] args) {
        int [] arr = {9, 12, 17, 30, 50, 20, 60, 65, 4, 49, -1};
        int[] arr2 = {4, 6, 8, 5, 9};

        System.out.println("堆排序前：" + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("堆排序后：" + Arrays.toString(arr));
    }


    private static void heapSort(int[] arr) {
        if (arr.length > 1) {
            // 首先 从第一个 非叶子节点开始 构造一个大顶堆
            for (int i = (arr.length-1)/2; i >= 0; i --) {
                adjustHeap2(arr, i, arr.length);
            }
            System.out.println(Arrays.toString(arr));

            // 然后 以此堆顶与最后一个叶子节点交换 获取当前最大元素 并继续调整剩余范围至满足大顶堆状态
            for (int i = arr.length - 1; i > 0; i --) {
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                adjustHeap2(arr, 0, i);
            }
        }
    }

    private static void adjustHeap2(int[] arr, int idx, int len) {
        //将temp作为父节点
        int temp = arr[idx];
        //左孩子
        int lChild = 2 * idx + 1;

        while (lChild < len) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < len && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[idx] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            idx = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[idx] = temp;
    }

    private static void adjustHeap(int[] arr, int idx, int len) {
        int temp = arr[idx];
        for (int k = 2*idx + 1; k < len; k = 2*k + 1) {
            if (k + 1 < len && arr[k] < arr[k+1]) {
                k += 1;
            }
            if (temp < arr[k]) {
                //int tmp = arr[idx];
                arr[idx] = arr[k];
                //arr[k] = tmp;
                idx = k;
            } else {
                break;
            }
        }
        arr[idx] = temp;
    }
}
