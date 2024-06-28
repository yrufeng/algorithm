package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 */
public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1};
        int target = 0;
        int[][] temp = new int[2][2];
        temp[0] = new int[]{1,2};
        temp[1] = new int[]{3,4};
        Arrays.copyOf(temp, 1);
        System.out.println(temp);
        Arrays.sort(temp, Comparator.comparingInt(o -> o[0]));
        int[] arr2 = {};
        List<int[]> res = new ArrayList<>();
        res.toArray(new int[res.size()][]);

        System.out.println("符合条件的子数组数: " + subArraySum(arr, target));
    }

    // 暴力求解 n^2
    private static int subArraySum(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; i ++) {
            int sum = 0;
            for (int j = i; j >= 0; j --) {
                sum += arr[j];
                if (sum == target) {
                    res ++;
                }
            }
        }
        return res;
    }

    private static int subArraySum2(int[] arr, int target) {
        int res = 0;
        int[][] memo = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i ++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < arr.length; i ++) {
            for (int j = i; j < arr.length; j ++) {
                int tmp;
                if (j > 0 && memo[i][j-1] != Integer.MAX_VALUE) {
                    tmp = memo[i][j-1] + arr[j];
                } else {
                    tmp = cal(arr, i, j);
                    memo[i][j] = tmp;
                }
                if (tmp == target) res ++;
            }
        }

        return res;
    }

    private static int subArraySum3(int[] arr, int target) {
        int res = 0;
        int[] memo = new int[arr.length];
        return res;
    }

    private static int cal(int[] arr, int from, int to) {
        int sum = 0;
        while (from <= to) {
            sum += arr[from++];
        }
        return sum;
    }
}
