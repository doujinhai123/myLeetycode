package com.iqiyi.paopao.myleetycode.num;

import android.app.usage.UsageStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    //无序数组
    public static int[] twoSum(int[] nums, int target) {
       int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j+1;
                    return result;
                }
            }

        }
        return result;

    }
    //有序数组 两数之和

    public static int[] twoSumSort(int[] numbers, int target) {
        int[] result = new int[2];
        int first = 0;
        int end = numbers.length-1;
        while (first < numbers.length) {
            if(numbers[first] + numbers[end] == target) {
                result[0] = first+1;
                result[1] = end +1;
                return result;
            } else if(numbers[first] + numbers[end]  < target) {
                first ++;
            } else  {
                end -- ;
            }
        }
        return result;
    }
    // 三数之和
    private List<List<Integer>> squeezeSolution(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int head = i +1;
            int tail = nums.length-1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if(sum == nums[i]) {
                    List<Integer> value = Arrays.asList(nums[i], nums[head], nums[tail]);
                     result.add(value);
                } else if(sum < nums[i]) {
                    tail--;
                } else {
                    head ++;
                }
            }

        }
        return Collections.emptyList();

    }
   //数组中是否存在重复元素
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) {
                return true;
            } else  {
                hashSet.add(nums[i]);
            }
        }
        return  false;
    }
    //统计一个数字在排序数组中出现的次数
    public int search(int[] nums, int target) {
        if(nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count ++;
            }

        }
        return count;

    }
    public static int binarySearch(int[] nums, double target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
    // 任意一个重复数字
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return -1;

    }
    //旋转数组中的最小数字
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i] > numbers[i+ 1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];

    }
    //数组中只出现一次
    public static int[] singleNumbers(int[] nums) {
        int j = 0;
        int counter = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                int count = hashMap.get(nums[i]);
                count = count +1;
                hashMap.put(nums[i],count);
            } else {
                hashMap.put(nums[i],counter);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() == 0) {
                arrayList.add(entry.getKey());
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);

        }
        return arr;

    }
    //只有一个重复的整数，找出这个重复的整数

    public int findDuplicate(int[] nums) {
         HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])) {
                return nums[i];
            } else  {
                hashSet.add(nums[i]);
            }
        }
        return -1;

    }
    //数组中次数超过一半的数字
    public static int majorityElement(int[] nums) {
        int j = 0;
        int counter = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                int count = hashMap.get(nums[i]);
                count = count +1;
                hashMap.put(nums[i],count);
            } else {
                hashMap.put(nums[i],counter);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() >= nums.length/2) {
                arrayList.add(entry.getKey());
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);

        }
        return arr[0];

    }
//和为S的两个数
public int[] twoSumss(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int [] result = new int[2];
        while (start <= end) {
            if(nums[start] +nums[end] == target) {
                result[0] = nums[start];
                result [1] =  nums[end];
                return result;
            } else  if(nums[start] +nums[end] < start) {
                start++;
            } else {
                end --;
            }
        }
        return result;

}
    //数组中的逆序对
    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length-1; j++) {
                if(nums[i] > nums[j+1]) {
                    count ++;

                }
            }

        }
        return count;

    }

//把奇数放到偶数的前面
    public int[] exchange(int[] nums) {
        int left = 0;
        int end = nums.length-1;
        while (left <= end) {
            if(nums[left] %2 != 0) {
                left++;
                continue;
            }
            if(nums[end] %2 != 1) {
                end --;
                continue;
            }
            int replace = nums[left];
            nums[left] = nums[end];
            nums[end] = replace;
        }
        return nums;

    }
    //二分查找

//    public int search(int[] nums, int target) {
//        int left = 0;
//        int end  = nums.length-1;
//        while (left <= end) {
//            int middle = left + (end - left) / 2;
//            if(nums[middle] == target) {
//                return middle;
//            } else if(nums[middle] < target) {
//                left = middle +1;
//
//            } else {
//                end = middle -1;
//            }
//        }
//        return -1;
//
//    }
    //把数组排成最小的数
//    public String minNumber(int[] nums) {
//        String[] strs = new String[nums.length];
//        for(int i = 0; i < nums.length; ++i)
//            strs[i] = String.valueOf(nums[i]);
//        Arrays.sort(strs,(o1,o2) -> {
//            return (o1+o2).compareTo(o2+o1);
//        });
//        StringBuilder sb = new StringBuilder();
//        for(String s: strs)
//            sb.append(s);
//        return sb.toString();
//    }
    //翻转单词顺序

    public static String reverseWords(String s) {
        String[] ss = s.trim().split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = ss.length-1; i >= 0; i--) {
            if(ss[i].trim().length() == 0) {
                continue;
            }

          stringBuffer.append(ss[i]).append(" ");
        }
        return stringBuffer.toString().trim();

    }




}
