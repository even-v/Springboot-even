package cn.even.dataStructure.sort;

/**
 * <p>
 * 描述: 快速排序，属于交换排序的一种。
 * 通过一趟排序将要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，
 * 以此达到整个数据变成有序序列。
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-17
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateIntArr(10);

        System.out.println("排序前：" + ArrayUtil.toString(arr));

        sort(arr);

        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }


    /**
     * <p>
     * 功能描述: 快速排序
     * 〈/P〉
     *
     * @param arr 待排序的数组
     * @author ipark123@163.com
     */
    private static void sort(int[] arr) {
        if(arr==null||arr.length<=1){
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    /**
     * <p>
     * 功能描述: 快速排序
     * 〈/P〉
     *
     * @param arr   待排序的数组
     * @param start 开始位置
     * @param end   结束为止
     * @author ipark123@163.com
     */
    private static void sort(int[] arr, int start, int end) {
        if(arr==null||arr.length<=1){
            return;
        }
        if (start < end) {
            int stand = arr[start];//标准数
            int low = start; //低位
            int height = end;//高位

            while (low < height) {
                while (low < height && arr[height] >= stand) {//高位数比标准数大，则高位向前移动
                    height--;
                }
                //此时高位数比标准数小，把高位赋值给低位
                arr[low] = arr[height];

                while (low < height && arr[low] <= stand) {//低位数比标准数小，则低位往后移动
                    low++;
                }
                //此时低位数比标准数大，把低位赋值给高位
                arr[height] = arr[low];
            }

            //此时高位低位重叠，把标准数赋值给当前位置
            arr[low] = stand;

            //当前位向前继续排序
            sort(arr, start, low);

            //当前位向后继续排序
            sort(arr, low + 1, end);
        }

    }
}
