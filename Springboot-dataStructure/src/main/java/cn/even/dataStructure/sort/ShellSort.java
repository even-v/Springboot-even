package cn.even.dataStructure.sort;

/**
 * <p>
 * 描述: 希尔排序，属于插入排序。
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 * 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-18
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateIntArr(10);

        System.out.println("排序前：" + ArrayUtil.toString(arr));

        sort(arr);

        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }

    /**
     * <p>
     * 功能描述:希尔排序
     * 〈/P〉
     *
     * @param arr 待排序的数组
     */
    private static void sort(int[] arr) {
        if(arr==null||arr.length<=1){
            return;
        }
        //step表示增量，步长
        for (int step = arr.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < arr.length; i++) {//从step开始比较
                for (int j = i - step; j >= 0; j -= step) { //从i-step开始往前比，步长step
                    if (arr[j] > arr[j + step]) {
                        ArrayUtil.swap(arr, j + step, j);
                    }
                }
            }
        }
    }


}
