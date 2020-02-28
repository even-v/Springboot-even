package cn.even.dataStructure.sort;

/**
 * <p>
 * 描述: 归并排序，属于归并排序
 * 是建立在归并操作上的一种有效的排序算法,
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为二路归并。
 * 归并排序是一种稳定的排序方法。
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-18
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateIntArr(9);

        System.out.println("第0轮排序前：" + ArrayUtil.toString(arr));

        sort(arr);

        System.out.println("第n轮排序后：" + ArrayUtil.toString(arr));
    }

    /**
     * <p>
     * 功能描述: 归并排序
     * 〈/P〉
     *
     * @param arr 待排序的数组
     */
    private static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    /**
     * <p>
     * 功能描述:  归并排序
     * 〈/P〉
     *
     * @param low    低位
     * @param height 高位
     * @param arr    待排序的数组
     */
    private static void sort(int[] arr, int low, int height) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        if (low < height) {
            //中间位置
            int mid = (low + height) / 2;

            //排序low一侧
            sort(arr, low, mid);

            //排序height一侧
            sort(arr, mid + 1, height);

            //归并
            sort(arr, low, mid, height);
        }

    }

    /**
     * <p>
     * 功能描述:  归并排序
     * 〈/P〉
     *
     * @param low    低位
     * @param mid    中间位
     * @param height 高位
     * @param arr    待排序的数组
     */
    private static void sort(int[] arr, int low, int mid, int height) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[height - low + 1];//临时数组存放需排序数组分割的排序后两边数组的值

        int i = low;//左侧开始位置
        int j = mid + 1; //右侧开始位置
        int index = 0; //temp临时数组下标

        while (i <= mid && j <= height) {
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i];
                i++;
            } else {
                temp[index++] = arr[j];
                j++;
            }
        }

        while (i <= mid) {
            temp[index++] = arr[i];
            i++;
        }

        while (j <= height) {
            temp[index++] = arr[j];
            j++;
        }

        //临时数组元素放入需排序的数组中
        for (int m = 0; m < temp.length; m++) {
            arr[m + low] = temp[m];
        }

    }
}
