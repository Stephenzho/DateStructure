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

    private static void mergeSort(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }

        int m = (i + j) / 2;
        mergeSort(arr, i, m);
        mergeSort(arr, m + 1, j);

        // 将两个数组合并
        merge(arr, i, m, j);
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



    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}
