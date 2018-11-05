package sort;

import java.util.Arrays;

/**
 * @author zhoushuyi
 * @since 2018/11/4
 */
public class MergeSort {


    /**
     * 归并排序
     * @param arr
     * @return
     */
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        // 小于15个用插入排序更优
        if (r - l <= 15 && r - l > 0) {
            insertionSort(arr, l, r);
            return;
        }

        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        // 将两个数组合并
        if (arr[m] > arr[m + 1]) {
            merge(arr, l, m, r);
        }
    }

    /**
     * 自底向上排序
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeSortBU(int[] arr, int l, int r) {
        int n = arr.length;

        for( int sz = 1; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1] > arr[i+sz]  )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }

    /**
     * 归并操作
     * @param arr   待归并数组
     * @param l     左起始点
     * @param m     中间节点
     * @param r     右终点
     */
    private static void merge(int[] arr, int l, int m, int r) {

        int[] a = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = m+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > m ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = a[j-l];
                j ++;
            } else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = a[i-l];
                i ++;
            } else if( a[i-l] < (a[j-l]) ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = a[i-l];
                i ++;
            } else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = a[j-l];
                j ++;
            }
        }
    }

    /**
     * 用于优化的插入排序
     * @param arr
     * @param l
     * @param r
     */
    private static void insertionSort(int[] arr, int l, int r) {

        for (int i = l+1; i <= r; i++) {
            for (int j = i; j > l; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int n = arr[i];
        arr[i] = arr[j];
        arr[j] = n;
    }



    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
