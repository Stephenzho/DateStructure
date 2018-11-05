package sort;

import java.util.Random;

/**
 * 快速排序
 * @author zhoushuyi
 * @since 2018/11/5
 */
public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {

        if (r - l <= 0) {
            return;
        }

        int k = partition(arr, l, r);

        quickSort(arr, l, k - 1);
        quickSort(arr, k + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {

        swap(arr, l, (int) (Math.random() % (r - l + 1)) + l);

        int v = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr,++j, i);
            }
        }
        swap(arr, j, l);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int n = arr[i];
        arr[i] = arr[j];
        arr[j] = n;
    }

}
