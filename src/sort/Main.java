package sort;

import java.util.Random;

/**
 * @author zhoushuyi
 * @since 2018/11/5
 */
public class Main {

    public static void main(String[] args) {


        int[] arr = arr(2000);

        long l = System.currentTimeMillis();
        QuickSort.sort(arr);
        long r = System.currentTimeMillis();


        System.out.println("耗时："+ (r - l));
        MergeSort.print(arr);

    }


    public static int[] arr(int n) {
        Random ran = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = ran.nextInt(n);
        }
        return arr;
    }
}
