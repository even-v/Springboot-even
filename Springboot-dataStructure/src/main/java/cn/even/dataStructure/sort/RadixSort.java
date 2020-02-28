package cn.even.dataStructure.sort;

import java.util.Arrays;

/**
 * <p>
 * 描述:基数排序（radix sort）。
 * 属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或bin sort，顾名思义，
 * 它是透过键值的部份资讯，将要排序的元素分配至某些“桶”中，藉以达到排序的作用，
 * 基数排序法是属于稳定性的排序，其时间复杂度为O (nlog(r)m)，
 * 其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 *
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date ${DATE}
 */
public class RadixSort {

    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateIntArr(10);

        System.out.println("排序前：" + ArrayUtil.toString(arr));

        sort(arr);

        System.out.println("排序后：" + ArrayUtil.toString(arr));
    }


    /**
     * <p>
     * 功能描述: 基数排序
     * 〈/P〉
     *
     * @param arr 待排序的数组
     */
    private static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //找到最大值
        int max = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }

        //找到最大值的长度
        int length = 0;
        if (max == 0) {
            length = 1;
        } else {
            for (; max != 0; max /= 10) {
                length++;
            }
        }

        //开始排序
        sort(arr, length);
    }

    /**
     * <p>
     * 功能描述: 基数排序
     * 〈/P〉
     *
     * @param arr   待排序的数组
     * @param digit 需要排序的次数(数组中最大值的长度)
     */
    private static void sort(int[] arr, int digit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < digit; i++, dev *= 10, mod *= 10) {
            //考虑负数，扩展一倍数组（0~9对应负数；10~19对应整数）
            int[][] temp = new int[mod * 2][0];
            for (int v : arr) {
                int bucket = ((v % mod) / dev) + mod;
                temp[bucket] = arrAppend(temp[bucket], v);
            }

            int pos = 0;
            for (int[] bucket : temp) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }

        }
    }

    /**
     * <p>
     * 功能描述: 拷贝数组使得长度加1，并把 val 赋给拷贝后的数组最后一个位置
     * 〈/P〉
     *
     * @param arr 原数组
     * @param val 值
     * @return 新数组
     */
    private static int[] arrAppend(int[] arr, int val) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = val;
        return arr;
    }
}
