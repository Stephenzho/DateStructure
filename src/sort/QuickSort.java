package sort;

/**
 * 快速排序
 * @author zhoushuyi
 * @since 2018/11/5
 */
public class QuickSort {

    public static void sort(int[] arr) {
        quickSort3(arr, 0, arr.length - 1);
    }


    /**
     * 三路快速排序
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort3(int[] arr, int l, int r) {
        swap(arr, l, (int) Math.random() % (r - l + 1) + l);

        int v = arr[l];

        int lt = l;
        int gt = r + 1;
        int e = l + 1;

        while (gt > e) {
            if (arr[e] > v) {
                swap(arr, gt - 1, e);
                gt--;
            } else if (arr[e] < v) {
                swap(arr, lt + 1, e);
                lt++;
                e++;
            } else {
                e++;
            }
        }
        swap(arr, lt, l);

        quickSort(arr, l, lt - 1);
        quickSort(arr, gt, r);
    }



    private static void quickSort(int[] arr, int l, int r) {

        if (r - l <= 0) {
            return;
        }

        int k = partition2(arr, l, r);

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

    private static int partition2(int[] arr, int l, int r) {
        swap(arr, l, (int) Math.random() % (r - l + 1) + l);

        int v = arr[l];
        int i = l+1, j = r;

        while (true) {
            while (i <= r && arr[i] < v) {
                i++;
            }
            while (j >= l+1 && arr[j] > v) {
                j--;
            }

            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);

        return j;
    }



    private static void swap(int[] arr, int i, int j) {
        int n = arr[i];
        arr[i] = arr[j];
        arr[j] = n;
    }

}
