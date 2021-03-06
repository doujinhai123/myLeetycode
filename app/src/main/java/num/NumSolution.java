package num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class NumSolution {


    static {

        aa = 5555;

    }

    static int aa = 33;

    static {
        System.out.println("sdsdsdsds" + aa);
    }


    public static void quickSort(int[] arr, int begin, int end) {

        // 数组为空
        if (arr == null || arr.length < 1) {
            return;
        }

        if (begin >= end) {
            return;
        }

        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);

    }

    public static int partition(int[] arr, int begin, int end) {
        if (begin >= end) {
            return begin;
        }
        int pivot = arr[begin];

        while (begin < end) {

            while (begin < end && pivot <= arr[end]) {
                end--;
            }

            if (begin < end) {
                arr[begin] = arr[end];
            }

            while (begin < end && pivot >= arr[begin]) {
                begin++;
            }

            if (begin < end) {
                arr[end] = arr[begin];
            }

            arr[begin] = pivot;
        }

        return begin;
    }

    //x的n次幂函
    public static double caalulatePower(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        }
        double result = 1.0d;
        int e = exponent > 0 ? exponent : -exponent;
        for (int i = 1; i <= e; i++) {
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }


    //无序数组
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j + 1;
                    return result;
                }
            }

        }
        return result;

    }
    //有序数组 两数之和

    public static int[] twoSumSort(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        while (start <= end) {
            if (nums[start] + nums[end] == target) {
                result[0] = nums[start];
                result[1] = nums[end];
                return result;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
        //第二种用hash表
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            //如果存在则返回
//            if (map.containsKey(target - nums[i])) {
//                return new int[]{target - nums[i], nums[i]};
//            } else {
//                    //不存在则存入
//            map.put(nums[i], i);
//            }
//        }
//        return new int[0];

    }


    // 三数之和
    private static List<List<Integer>> squeezeSolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> value = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(value);
                } else if (sum < nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }

        }
        return Collections.emptyList();

    }

    //数组中是否存在重复元素
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return false;
    }

    //统计一个数字在排序数组中出现的次数
    public int search(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
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
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    // 任意一个重复数字
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return -1;

    }

    //旋转数组中的最小数字
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];

    }

    //数组中只出现一次
    public static int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int count = hashMap.get(nums[i]);
                count = count + 1;
                hashMap.put(nums[i], count);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                arrayList.add(entry.getKey());
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);

        }
        return arr;

    }


    //数组中次数超过一半的数字
    public static int majorityElement(int[] nums) {
        int j = 0;
        int counter = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int count = hashMap.get(nums[i]);
                count = count + 1;
                hashMap.put(nums[i], count);
            } else {
                hashMap.put(nums[i], counter);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() >= nums.length / 2) {
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
        int end = nums.length - 1;
        int[] result = new int[2];
        while (start <= end) {
            if (nums[start] + nums[end] == target) {
                result[0] = nums[start];
                result[1] = nums[end];
                return result;
            } else if (nums[start] + nums[end] < start) {
                start++;
            } else {
                end--;
            }
        }
        return result;

    }

    //数组中的逆序对
    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[i] > nums[j + 1]) {
                    count++;

                }
            }

        }
        return count;

    }

    //把奇数放到偶数的前面
    public static int[] exchange(int[] nums) {
        int left = 0;
        int end = nums.length - 1;
        while (left <= end) {
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            if (nums[end] % 2 != 1) {
                end--;
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


    // 和为S的整数序列
    public static int[][] findContinuousSequence(int target) {
        if (target == 2) return null;
        List<int[]> lists = new ArrayList<>();
        int min = 1, max = 2;
        int sum = 3;
        while (min <= target / 2) {
            if (sum > target) {
                sum -= min;
                min++;
            } else {
                if (sum == target)
                    lists.add(getOneArray(min, max));
                max++;
                sum += max;
            }
        }
        return lists.toArray(new int[0][]);
    }

    private static int[] getOneArray(int lo, int hi) {
        int[] res = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            res[i - lo] = i;
        }
        return res;
    }


    //青蛙跳台阶问题
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];

    }

    //非博纳数列
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];

    }

    //机器人路径
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    //旋转数组中的最小值
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return nums[0];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return -1;
    }

    //二维数组的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }

        }
        return false;

    }

//二进制中1的个数

    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        char num[] = s.toCharArray();
        int res = 0;
        for (int i : num) {
            if (i == '1') res++;
        }
        return res;


    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;//0.预处理

        int[] res = new int[nums.length - k + 1];
        //找出滑动窗口一开始的max值，并放入res
        int max = nums[0];
        for (int j = 0; j < k; j++) {
            if (nums[j] > max) max = nums[j];
        }
        res[0] = max;
        //向后滑动
        for (int i = 1; i <= nums.length - k; i++) {
            if (nums[i - 1] == max) {//如果窗口丢掉的值是滑动前的max，就重新在窗口内找max
                max = nums[i];
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] > max) max = nums[j];
                }
            } else {//如果窗口丢掉的值不是之前的max，就在max和新加入窗口的值之中找大的一个
                max = Math.max(max, nums[i + k - 1]);
            }
            res[i] = max;//放入res
        }
        return res;
    }

    //顺时针打印矩阵
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int up = 0;
        int down = matrix.length - 1; //行高
        int left = 0;
        int right = matrix[0].length - 1; // 列高
        while (true) {
            //向右
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            if (++up > down) {
                break;
            }
            //向下
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            //向左
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            //向上
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[][] matrix = new int[3][4];
        //快速排序
        quickSort(array, 0, array.length - 1);
        //奇数和偶数调换
        exchange(array);
        //二分查找
        System.out.println(binarySearch(array, 7));
        //二分查找 找到连个索引
        System.out.println(twoSumSort(array, 6));
        ///三数之和为0
        System.out.println(squeezeSolution(array));
        ///数组中只出现一次的次数
        System.out.println(singleNumbers(array));
        //和为S的整数序列
        findContinuousSequence(15);
        //滑动窗口的最大值
        maxSlidingWindow(array, 6);
        //顺时针打印矩阵
        printMatrix(matrix);

    }
};



