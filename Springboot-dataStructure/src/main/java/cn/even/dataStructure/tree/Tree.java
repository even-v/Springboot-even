package cn.even.dataStructure.tree;

import lombok.Data;

/**
 * <p>
 * 描述: 数结构
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-21
 */
@Data
public class Tree<T> {
    private Node<T> node;

    public Tree(Node<T> node) {
        this.node = node;
    }


    /**
     * <p>
     * 功能描述: 递归实现先序遍历
     * 〈/P〉
     */
    public void preorderTraversal_recursion() {
        node.preorderTraversal_recursion(node);
    }

    /**
     * <p>
     * 功能描述: 递归实现先序遍历
     * 〈/P〉
     */
    public void middleorderTraversal_recursion() {
        node.middleorderTraversal_recursion(node);
    }

    /**
     * <p>
     * 功能描述: 递归实现后序遍历
     * 〈/P〉
     */
    public void postorderTraversal_recursion() {
        node.postorderTraversal_recursion(node);
    }

    /**
     * <p>
     * 功能描述: 利用栈结构循环实现先序遍历
     * 〈/P〉
     */
    public void preorderTraversal_loop() {
        node.preorderTraversal_loop(node);
    }
}
