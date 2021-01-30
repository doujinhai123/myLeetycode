package String;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;


public class StringSolution {
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
    public static String reverseLeftWords(String s, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = n; i < s.length(); i++) {
            stringBuffer.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();

    }

    public static boolean judge(String str) {
        if (str == null && str.length() <= 1) return true;
        // write code here
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    //第一个只出现一次的字符
    public static char firstUniqChar(String s) {
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
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    //替换空格
    public static String replaceSpace(String s) {
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
    //大数相乘
    public static String solve (String s, String t) {
        // write code here
        // write code here
        int m=s.length(),n=t.length();
        int[] ss=new int[m];
        int[] tt=new int[n];
        int[] result=new int[m+n];
        for (int i=0;i<m;i++){
            ss[i]=s.charAt(i)-'0';
        }
        for (int j=0;j<n;j++){
            tt[j]=t.charAt(j)-'0';
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                result[i+j]+=ss[i]*tt[j];
            }
        }
        for (int i=m+n-1;i>=1;i--){
            int temp=result[i];
            result[i]=temp%10;
            result[i-1]+=temp/10;
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<m+n-1;i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }

    //有效的括号
    public static boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        if (stack.empty())
            return true;
        return false;
    }

    //字符串转int
    public static int strToIntResult(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] == '+') {
            sign = 1;
        } else {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }


    public static void main(String[] args) {
        //字符串转int
        System.out.println(strToIntResult("1234"));
        //大数相加
        addStrings("123","345");
        //大数相乘
        solve("123","456");
        //第一个只出现一次的字符
        firstUniqChar("sds");
        //坐旋转字符串
        reverseLeftWords("dddd", 6);
        //反转单次顺序
        reverseWords("sdss");
        //判断是不是回文
        judge("wewewe");
        //有效括号
        System.out.println(isValid("()"));
        //替换空格
        replaceSpace("sdd");
    }
}
