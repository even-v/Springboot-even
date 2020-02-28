package cn.even.dataStructure.tree;

import lombok.Data;

import java.util.Stack;

/**
 * <p>
 * 描述: 树的节点
 * </p>
 *
 * @author ipark123@163.com
 * @version 1.0.0
 * @date 2020-02-21
 */
@Data
public class Node<T> {

    /**
     * 节点数据
     */
    private T data;

    /**
     * 左儿子
     */
    private Node<T> leftChild;

    /**
     * 右儿子
     */
    private Node<T> rightChild;


    /**
     * <p>
     * 功能描述: 递归实现先序遍历
     * 〈/P〉
     *
     * @param node 需要遍历的树的根节点
     */
    public void preorderTraversal_recursion(Node<T> node) {
        if (node == null) {
            return;
        }
        //先访问根节点
        System.out.println(node.getData());

        //然后访问左节点
        preorderTraversal_recursion(node.getLeftChild());

        //最后访问右节点
        preorderTraversal_recursion(node.getRightChild());
    }

    /**
     * <p>
     * 功能描述: 递归实现先序遍历
     * 〈/P〉
     *
     * @param node 需要遍历的树的根节点
     */
    public void middleorderTraversal_recursion(Node<T> node) {
        if (node == null) {
            return;
        }

        //先访问左节点
        middleorderTraversal_recursion(node.getLeftChild());

        //然后访问根节点
        System.out.println(node.getData());

        //最后访问右节点
        middleorderTraversal_recursion(node.getRightChild());
    }

    /**
     * <p>
     * 功能描述: 递归实现后序遍历
     * 〈/P〉
     *
     * @param node 需要遍历的树的根节点
     */
    public void postorderTraversal_recursion(Node<T> node) {
        if (node == null) {
            return;
        }
        //先访问左节点
        postorderTraversal_recursion(node.getLeftChild());

        //然后访问右节点
        postorderTraversal_recursion(node.getRightChild());

        //最后访问根节点
        System.out.println(node.getData());
    }

    /**
     * <p>
     * 功能描述: 利用栈结构循环实现先序遍历
     * 〈/P〉
     *
     * @param node 需要遍历的树的根节点
     */
    public void preorderTraversal_loop(Node<T> node) {
        if (node == null) {
            return;
        }
        Stack<Node<T>> temp = new Stack<>();//使用栈作为辅助
        Node<T> tempNode = null;
        temp.add(node);
        while (!temp.isEmpty()) {//不为空
            tempNode = temp.pop();
            System.out.println(tempNode.data);

            if (tempNode.getRightChild() != null) {//先存入右儿子，根据栈的特性会后出栈
                temp.push(tempNode.getRightChild());
            }
            if (tempNode.getLeftChild() != null) {//后存入左儿子，根据栈的特性会先出栈
                temp.push(tempNode.getLeftChild());
            }

        }
    }


    public Node(T data) {
        this.data = data;
    }
}
