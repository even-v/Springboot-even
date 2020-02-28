package cn.even.dataStructure.sort;

import java.util.Random;

/**
 * <p>
 * 描述: 数组工具类，生成数组，打印数组等
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-17
 */
public class ArrayUtil {

    /**
     * <p>
     * 功能描述: 生成长度为length的整型数组
     * 〈/P〉
     *
     * @param length 数组长度
     * @return 长度为length的整型数组
     * @author ipark123@163.com
     */
    public static int[] generateIntArr(int length) {
        if (length <= 0) {
            return null;
        }
        int[] arr = new int[length];
        for (int i = 0; i < length - 1; i++) {
            arr[i] = new Random().nextInt(100);
        }
        arr[length - 1] = new Random().nextInt(90);
        return arr;
    }


    /**
     * 交换数组 i 和 j 位置的值
     *
     * @param arr 数组
     * @param i   下标
     * @param j   下标
     */
    public static void swap(int[] arr, int i, int j) {
        if (i < 0 || j < 0 || arr == null || arr.length == 0 || (i > (arr.length - 1)) || (j > (arr.length - 1))) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * <p>
     * 功能描述: 返回整型数组字符串表示
     * 〈/P〉
     *
     * @param arr 整型数组
     * @return 字符串表示的数组
     * @author ipark123@163.com
     */
    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append("\t");
        }
        sb.append("\n");
        return sb.toString();
    }
}
