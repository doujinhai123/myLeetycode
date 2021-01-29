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

public class NumSolution {


    static {

        aa = 5555;

    }

    static int aa = 33;

    static {
        System.out.println("sdsdsdsds" + aa);
    }

    public static int[] mySortFast(int[] arr) {
        // write code here
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(int[] arr, int begin, int end) {

        // 数组为空
        if(arr == null || arr.length < 1) {
            return;
        }

        if(begin >= end) {
            return;
        }

        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);

    }
    public static int partition(int[] arr, int begin, int end) {
        if(begin >= end) {
            return begin;
        }
        int pivot = arr[begin];

        while(begin < end) {

            while(begin < end && pivot <= arr[end]) {
                end --;
            }

            if(begin < end) {
                arr[begin] = arr[end];
            }

            while(begin < end && pivot >= arr[begin] ) {
                begin++;
            }

            if(begin < end) {
                arr[end] = arr[begin];
            }

            arr[begin] = pivot;
        }

        return begin;
    }

    //字符串转整数
    public int strToInt(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0) return 0;
        while (str.charAt(i) == ' ')
            if (++i == length) return 0;
        if (str.charAt(i) == '-') sign = -1;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        for (int j = i; j < length; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') break;
            if (res > bndry || res == bndry && str.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
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

    public static int[] twoSumSort(int[] numbers, int target) {
        int[] result = new int[2];
        int first = 0;
        int end = numbers.length - 1;
        while (first < numbers.length) {
            if (numbers[first] + numbers[end] == target) {
                result[0] = first + 1;
                result[1] = end + 1;
                return result;
            } else if (numbers[first] + numbers[end] < target) {
                first++;
            } else {
                end--;
            }
        }
        return result;
    }

    // 三数之和
    private List<List<Integer>> squeezeSolution(int[] nums) {
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
            }
        }
        return left;
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
            if (entry.getValue() == 0) {
                arrayList.add(entry.getKey());
            }
        }
        int[] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);

        }
        return arr;

    }

    //第一个只出现一次的字符
    public char firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        int j = 0;
        int counter = 0;

        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (hashMap.containsKey(ss[i])) {
                int count = hashMap.get(ss[i]);
                count = count + 1;
                hashMap.put(ss[i], count);
            } else {
                hashMap.put(ss[i], counter);
            }
        }
        ArrayList<Character> arrayList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return ' ';


    }


    //只有一个重复的整数，找出这个重复的整数

    public int findDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return nums[i];
            } else {
                hashSet.add(nums[i]);
            }
        }
        return -1;

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
    public int[] exchange(int[] nums) {
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
    //翻转单词顺序

    public static String reverseWords(String s) {
        String[] ss = s.trim().split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].trim().length() == 0) {
                continue;
            }

            stringBuffer.append(ss[i]).append(" ");
        }
        return stringBuffer.toString().trim();

    }

    //左旋抓字符串
    public String reverseLeftWords(String s, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n; i < s.length(); i++) {
            stringBuffer.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();

    }

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

    ////连续子数组的最大和
//public int maxSubArray(int[] nums) {
//
//}
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

    //替换空格
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(s.charAt(i));
            }
        }
        return stringBuffer.toString();

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

    //大数相加
    public static String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            s.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        return s.reverse().toString();//对字符串反转
    }

    public static void main(String[] args) {
        int[] fastASrray = new int[]{6,35,67,8,2,45,67,98,343};
        mySortFast(fastASrray);
        for (int i = 0; i < fastASrray.length; i++) {
            System.out.println(fastASrray[i]);
        }
    }


}
