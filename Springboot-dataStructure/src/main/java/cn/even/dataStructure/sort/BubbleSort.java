package cn.even.dataStructure.sort;

/**
 * <p>
 * 描述: 冒泡排序，属于交换排序的一种。
 * 它重复地走访过要排序的元素列，依次比较两个相邻的元素，
 * 如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来。
 * 走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-18
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateIntArr(10);

        System.out.println("排序前：" + ArrayUtil.toString(arr));

        sort(arr);

        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }

    /**
     * <p>
     * 功能描述: 冒泡排序
     * 〈/P〉
     *
     * @param arr 待排序的数组
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {//排序趟数
            for (int j = 0; j < arr.length - i - 1; j++) {//比较次数
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
