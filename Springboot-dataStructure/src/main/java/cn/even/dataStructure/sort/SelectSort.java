package cn.even.dataStructure.sort;


/**
 * <p>
 * 描述: 简单选择排序。属于选择排序
 * <p>
 * 它的工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 * 以此类推，直到全部待排序的数据元素的个数为零。
 * 选择排序是不稳定的排序方法。
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-18
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateIntArr(10);

        System.out.println("排序前：" + ArrayUtil.toString(arr));

        sort(arr);

        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }

    /**
     * <p>
     * 功能描述: 选择排序
     * 〈/P〉
     *
     * @param arr 待排序的数组
     */
    private static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) { //排序趟数
            int min = arr[i];//认为i位置的值是最小的
            int minIndex = i;//认为i位置的值是最小的
            for (int j = i + 1; j < arr.length; j++) { //比较
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            ArrayUtil.swap(arr, minIndex, i);
        }
    }
}
