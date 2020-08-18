package com.iqiyi.paopao.myleetycode.num;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
       int[] result = new int[2];
       int first = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length-1; j++) {
                if(nums[j] + nums[j+1] == target) {
                    result[0] = j;
                    result[1] = j+1;
                    return result;
                }
            }

        }
        return result;

    }
}
