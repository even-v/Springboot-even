package cn.even.dataStructure.sort;

/**
 * <p>
 * 描述: 直接插入排序，属于插入排序。
 * 插入排序的基本思想是：每步将一个待排序的记录，
 * 按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-18
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateIntArr(9);

        System.out.println("第0轮排序前：" + ArrayUtil.toString(arr));

        sort(arr);

        System.out.println("第n轮排序后：" + ArrayUtil.toString(arr));
    }

    /**
     * <p>
     * 功能描述: 直接插入排序
     * 〈/P〉
     *
     * @param arr 待排序的数组
     */
    private static void sort(int[] arr) {
        if(arr==null||arr.length<=1){
            return;
        }
        //第一个数已排好序，从第二个开始向前插入
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int t = arr[i];
                int j;
                for (j = i - 1; j >= 0 && t < arr[j]; j--) {//从i位置向前找，满足条件就插入
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = t;
                System.out.println("第" + i + "轮排序后：" + ArrayUtil.toString(arr));
            }
        }
    }


}
