package hot;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int[] arr2 = {1,0,1};
        moveZeroes2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void moveZeroes2(int[] arr) {
        if (arr.length > 0) {
            int left = 0, right = 0, length = arr.length;
            while (right < length) {
                if (arr[right] != 0) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left ++;
                }
                right += 1;
            }
        }
    }

    public static void moveZeroes(int[] arr) {
        if (arr.length > 0) {
            for (int i = 0; i < arr.length; i ++) {
                if (arr[i] == 0 && i < arr.length-1) {
                    int j = i + 1;
                    while (arr[j] == 0 && j < arr.length-1) {
                        j ++;
                    }
                    if (arr[j] != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
