package hot;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(findThreeNumSumZero(nums));
    }

    private static List<List<Integer>> findThreeNumSumZero(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        if (arr.length >= 3) {
            Arrays.sort(arr);

            for (int i = 0; i < arr.length - 2; i ++) {
                if (arr[i] > 0) break;
                if (i > 0 && arr[i] == arr[i-1]) continue;

                int left = i+1, right = arr.length-1;
                while (left < right) {
                    int sum = arr[i] + arr[left] + arr[right];
                    if (sum > 0) {
                        //while(left < right && arr[right] == arr[--right]);
                        while (left < right) {
                            right -= 1;
                        }
                    } else if (sum < 0) {
                        //while(left < right && arr[left] == arr[++left]);
                        while (left < right) {
                            left += 1;
                        }
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[left]);
                        temp.add(arr[right]);
                        res.add(temp);
                        while(left < right && arr[left] == arr[++left]);
                        while(left < right && arr[right] == arr[--right]);
//                        while(arr[left] == arr[left + 1]) left ++;
//                        while(arr[right] == arr[right-1]) right --;
                    }
                }
            }
        }


        return res;
    }
}
