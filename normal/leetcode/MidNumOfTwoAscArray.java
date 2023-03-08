package leetcode;

/**
 * 给定两个大小分别为m和n的正序（从小到大）数组nums1和nums2。请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为O(log(m+n))
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 */

public class MidNumOfTwoAscArray {

    public static void main(String[] args) {
        // -10 -8 -1 -1 0 1 8 9 10
        int[] arr1 = {-1, 0, 8, 9, 18};
        int[] arr2 = {-10, -8, -1, 1};

        //double mid = findMidNumOfTwoAscArray(arr1, arr2);
        double mid = findMedianSortedArrays(arr1, arr2);

        System.out.println(mid);
    }

    public static double findMidNumOfTwoAscArray(int[] arr1, int[] arr2) {
        float mid = 0;
        int allLenght = arr1.length + arr2.length;
        boolean flag;
        int count = allLenght / 2;

        // 奇偶判断
        if (allLenght % 2 == 0) {
            //count = allLenght / 2;
            flag = true;
        } else {
            //count = allLenght
            flag = false;
        }

        int i = 0, j = 0;
        int pos = 0;
        while (i < arr1.length || j < arr2.length) {
            if (arr1[i] <= arr2[j] || j == arr2.length - 1) {
                i ++;
            } else {
                j ++;
            }
            pos ++;
            if (pos == count) {
                if (flag) {
                    //
                }
            }
        }

        return mid;
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1;
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1;
            }
            else {
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
