package DyanmicCode;

import java.util.ArrayList;
import java.util.TreeSet;

public class DynamicCode {
    //子数组的最大累加和
    public static int maxsumofSubarray(int[] arr) {
        // write code here
        if (arr.length == 0 || arr == null)
            return 0;
        int sum = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (sum + arr[i] > arr[i])
                sum = sum + arr[i];
            else
                sum = arr[i];
        }
        return sum;
    }

    //  最长公共子序列
    public static String LCS(String s1, String s2) {
        // write code here
        // write code here
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return "-1";
        int s1L = s1.length() - 1;
        int s2L = s2.length() - 1;
        StringBuilder str = new StringBuilder();
        while (s1L >= 0 && s2L >= 0) {
            if (s1.charAt(s1L) == s2.charAt(s2L)) {
                str.append(s1.charAt(s1L));
                s1L--;
                s2L--;
            } else {
                if (s1L >= 1 && s2L >= 1) {
                    if (Math.max(s1.charAt(s1L - 1), s2.charAt(s2L))
                            >= Math.max(s1.charAt(s1L), s2.charAt(s2L - 1)))
                        s2L--;
                    else
                        s1L--;
                } else if (s1L == 0) {
                    s2L--;
                } else
                    s1L--;
            }
        }
        if (str.length() == 0) return "-1";
        return str.reverse().toString();

    }

    public static String LCSs (String str1, String str2) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 1;
        while (end < str1.length() + 1) {
            if (str2.contains(str1.substring(start, end))) {
                if (sb.length() < end - start) {
                    sb.delete(0, sb.length());
                    sb.append(str1, start, end);
                }
                end++;
            } else {
                start++;
            }
        }
        if (sb.length() == 0) {
            return "-1";
        }
        return sb.toString();
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return arrayList;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<String>();
        Permation(chars, 0, temp);
        arrayList.addAll(temp);
        return arrayList;

    }

    private static void Permation(char[] chars, int begin, TreeSet<String> result) {
        // TODO Auto-generated method stub
        if (chars == null || chars.length == 0 || begin < 0
                || begin > chars.length - 1) {
            return;
        }
        if (begin == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            for (int i = begin; i <= chars.length - 1; i++) {
                swap(chars, begin, i);
                Permation(chars, begin + 1, result);
                swap(chars, begin, i);
            }
        }

    }

    private static void swap(char[] chars, int a, int b) {
        // TODO Auto-generated method stub
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static int[] LIS(int[] arr) {
        int n = arr.length;
// 列表的最大子序列 下标从1开始
        int[] end = new int[n + 1];
// 存储每个元素的最大子序列个数
        int[] dp = new int[n];
        int len = 1;
//子序列的第一个元素默认为数组第一个元素
        end[1] = arr[0];
//第一个元素的最大子序列个数肯定是1
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (end[len] < arr[i]) {
//当arr[i] > end[len] 时 arr[i]添加到 end后面
                end[++len] = arr[i];
                dp[i] = len;
            } else {
// 当前元素小于end中的最后一个元素 利用二分法寻找第一个大于arr[i]的元素
// end[l] 替换为当前元素 dp[]
                int l = 0;
                int r = len;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (end[mid] >= arr[i]) {
                        r = mid - 1;
                    } else l = mid + 1;
                }
                end[l] = arr[i];
                dp[i] = l;
            }
        }

        int[] res = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }


    public static int getLongestPalindrome(String A, int n) {
        // write code here
        char[] ch = A.toCharArray();
        int res = 0;
        for(int i = 0; i < n; i++){
            int l = i, r = i, sameR = i;
            //定位左右两边,避免abba和aba
            while(l - 1 >= 0 && ch[l - 1] == ch[i]) l--;
            while(r + 1 < n && ch[r + 1] == ch[i]) r++;
            sameR = r;

            while(l - 1 >= 0 && r + 1 < n && ch[l - 1] == ch[r + 1]){
                l--;
                r++;
            }

            res = Math.max(res, r - l + 1);

            //优化
            i = sameR;
        }
        return res;
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        if (m < 1 || n < 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int solve (String nums) {
        if(nums.length() == 0 || nums.charAt(0) == '0')
            return 0;
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            if(nums.charAt(i) != '0'){
                dp[i] = dp[i-1];
            }
            //  3 2 4
            int num = (nums.charAt(i-1)-'0')*10 + (nums.charAt(i)-'0');
            if(num >= 10 && num <= 26){
                if(i == 1){
                    dp[i] += 1;
                }else{
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[nums.length()-1];
    }


    public static void main(String[] args) {
        String si = "qwe";
        String s2 = "345";
        int[] result = {};
        //动态规划在下面
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        //子数组的最大累加和
        maxsumofSubarray(array);
        //  最长公共子序列
        LCS(si, s2);
        //最长公共子串
        LCSs(si, s2);
        //最长递增子序列
        LIS(result);
        // 最长回文子串
        getLongestPalindrome(s2,4);
        //机器人路径
        uniquePaths(3,4);
        //把数字翻译成字符串
        solve("123");
        //字符串的全排列
        Permutation(s2);

    }
}
