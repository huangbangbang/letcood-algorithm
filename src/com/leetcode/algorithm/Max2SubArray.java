package com.leetcode.algorithm;//给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为
//firstLen 和 secondLen 。
//
// 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
//
// 子数组是数组的一个 连续 部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
//输出：20
//解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
//
//
// 示例 2：
//
//
//输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
//输出：29
//解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
//
//
// 示例 3：
//
//
//输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
//输出：31
//解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
//
//
//
//
// 提示：
//
//
// 1 <= firstLen, secondLen <= 1000
// 2 <= firstLen + secondLen <= 1000
// firstLen + secondLen <= nums.length <= 1000
// 0 <= nums[i] <= 1000
//
//
// Related Topics 数组 动态规划 滑动窗口 👍 207 👎 0



class Max2SubArray {

    public static void main(String[] args) {
        int maxSum = maxSumTwoNoOverlap(new int[]{20,19,14,2,11,4,2,14,8,14,15,15}, 5, 7);
        System.out.println("两个子数组中最大和是：" + maxSum);
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max = 0;
        for (int i = 0; i <= nums.length-firstLen; i++) {
            int sum1 = sumOfArray(nums, firstLen, i);
            if (i>secondLen){
                for (int j = 0; j < i + 1 - secondLen; j++) {
                    int sum2 = sumOfArray(nums, secondLen, j);
                    int total = sum1 + sum2;
                    if (total>max){
                        max = total;
                    }
                }
            }
            if ((nums.length-i-firstLen)>=secondLen){
                for (int j = i+firstLen; j <= nums.length-secondLen; j++) {
                    int sum2 = sumOfArray(nums, secondLen, j);
                    int total = sum1 + sum2;
                    if (total>max){
                        max = total;
                    }
                }
            }

        }
        return max;
    }

    public static int sumOfArray(int[] nums ,int len,int index){
        if (len+index > nums.length+1){
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        int sum = 0;
        for (int i = index; i < index+len; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
