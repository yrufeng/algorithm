package hot;


import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 *
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] case1 = {100, 4, 200, 1, 3, 2};
        int[] case2 = {0, -1, 10};
        int[] case3 = {0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999};

        int res = longestConsecutive3(case2);
        System.out.println("数字连续的最长序列长度: " + res);
        BitSet demo = new BitSet(1);
        System.out.println(demo.length());
        demo.set(2000000000, true);
        System.out.println(demo.get(2000000000));
    }

    private static int longestConsecutive3(int[] nums) {
        Set<Integer> assistSet = new HashSet<>();

        for (int i = 0; i < nums.length; i ++) {
            assistSet.add(nums[i]);
        }
        int longestNum = 0;
        for (int i = 0; i < nums.length; i ++) {
            int currLongest = 0, currentNum = 0;
            if (!assistSet.contains(nums[i] - 1)) {
                currentNum = nums[i];
                while (assistSet.contains(currentNum)) {
                    currLongest += 1;
                    currentNum += 1;
                }
            }
            longestNum = Math.max(longestNum, currLongest);
        }


        return longestNum;
    }

    private static int longestConsecutive2(int[] nums) {
        long start = System.currentTimeMillis();
        int max = 0;

        if (nums.length > 0) {
            int minNum = nums[0];
            for (int i = 1; i < nums.length; i ++) {
                if (minNum > nums[i]) {
                    minNum = nums[i];
                }
            }
            int gap = minNum < 0 ? -minNum : 0;
            BitSet bitSet = new BitSet(16);
            for (int i = 0; i < nums.length; i ++) {
                bitSet.set(nums[i]+gap, true);
            }

            for (int i = 0; i < nums.length; i ++) {
                int fromIdx = Math.max(nums[i] - nums.length, 0);
                int toIdx = Math.min(nums[i] + nums.length, bitSet.size());
                BitSet tmp = bitSet.get(fromIdx, toIdx);
                int curr = 1;
                for (int j = 1; j < tmp.size(); j ++) {
                    if (bitSet.get(j-1) && bitSet.get(j)) {
                        curr += 1;
                    } else {
                        if (curr > max) {
                            max = curr;
                        }
                        curr = 1;
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end-start));

        return max;
    }

    private static int longestConsecutive(int[] arr) {
        int[] temporary = new int[2000000000];
        for (int i = 0; i < arr.length; i ++) {
            temporary[arr[i]+2000000000] = arr[i];
        }
        int curr = 1;
        for (int i = 1; i < temporary.length; i ++) {
            if (temporary[i] - temporary[i-1] == 1) {
                curr += 1;
            } else {
                curr -= 1;
            }
        }

        return curr;
    }
}
