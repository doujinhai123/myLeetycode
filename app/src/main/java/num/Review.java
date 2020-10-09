package num;

import static java.util.Arrays.sort;

public class Review {
    public static void main(String[] args) {

        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        int[] b = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] c = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] d = new int[]{1,10,2,9,3,2,4,7,5,6};


        for (int i = 0; i < a.length; i++) {
            System.out.println("sssssss"+a[i]);
        }

    }
    public int[] getLeastNumbers(int[] arr, int k) {
        fastSort(arr, 0, arr.length-1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
       return result;
    }
    public static void fastSort(int[] a, int start, int end){
        if(start > end){
            //如果只有一个元素，就不用再排下去了
            return;
        }
        else{
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = diverer(a, start, end);
            fastSort(a, start, partition-1);
            fastSort(a, partition+1, end);
        }

    }


    public static int  diverer(int[]a,int start, int end) {
        //每次都是以最右边的元素作为基准
        int base = a[end];
        //start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此轮循环
        while (start < end) {
            while (a[start] <= base && start <end) {
                start ++;
            }
            if(start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                end --;
            }

            while (a[end] >= base && start <end) {
                end --;
            }
            if(start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start ++;
            }


        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }
}
