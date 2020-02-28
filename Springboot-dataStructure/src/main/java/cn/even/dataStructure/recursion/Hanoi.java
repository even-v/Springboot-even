package cn.even.dataStructure.recursion;

/**
 * <p>
 * 描述: 使用递归解决汉诺塔问题
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-17
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(4, 'A', 'B', 'C');
    }

    /**
     * <p>
     * 功能描述: 递归解汉诺塔
     * 〈/P〉
     *
     * @author ipark123@163.com
     */
    public static void hanoi(int n, char from, char mid, char to) {
        if (n == 1) {
            //一个直接移动
            System.out.println("第" + n + "个盘子从" + from + "到" + to);
        } else {
            //借助第三个盘子把 n-1 个移至中间
            hanoi(n - 1, from, to, mid);

            //最后一个直接移动
            System.out.println("第" + n + "个盘子从" + from + "到" + to);

            //n-1个已经在中间：此时中间的借助第一个盘子把 n-1个移至第三个盘子
            hanoi(n - 1, mid, from, to);
        }
    }

}
