package sort;

/**
 * @author zhoushuyi
 * @since 2018/11/4
 */
public class InsertionSort {

    /**
     * 交换位置
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int n = arr[i];
        arr[i] = arr[j];
        arr[j] = n;
    }
    /**
     * 插入排序
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }

        }
    }

}
