package demo;

import javafx.util.Pair;

import java.util.*;

public class MapVisiteDemo {
    static Integer sumAll = 0;
    static boolean res = false;
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3,2);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

        }
        List<Integer> list = (ArrayList<Integer>)map.keySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> item = iterator.next();
            iterator.remove();
        }
        Pair<Integer, Integer> pair = new Pair<>(1,2);
        int a = 8, b = 8, c = 7;
        System.out.println(a ^ b ^ c);
        Map test = new HashMap<Object, Object>();
        int[] arr = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,99,97};
        System.out.println(ways_1(arr));
    }

    // 转为在数组中 找到满足和为target的子序列
    private static boolean ways_1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        Arrays.sort(nums);
        System.out.println("look: " + sum + " " + nums.length);
        check(nums, 0, sum/2);
        return res;
    }

    private static void check(int[] nums, int idx, int target) {

        if (idx > nums.length - 1) return;
        if (sumAll > target) return;

        if (sumAll == target) {
            res = true;
            return;
        }
        System.out.println("look: " + " " + idx + " " + sumAll + " " + nums.length + " " + target);

        for (int i = idx; i < nums.length; i++) {

            sumAll += nums[i];
            check(nums, idx + 1, target);
            sumAll -= nums[i];
        }
    }
}
