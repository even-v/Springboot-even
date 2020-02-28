package cn.even.dataStructure.tree;


public class Test {
    public static void main(String [] args){
        Node<Integer> root=new Node<>(1);
        Node<Integer> left_1=new Node<>(2);
        Node<Integer> right_1=new Node<>(3);

        Node<Integer> left_1_left=new Node<>(4);
        Node<Integer> left_1_right=new Node<>(5);

        Node<Integer> right_1_left=new Node<>(6);
        Node<Integer> right_1_right=new Node<>(7);

        left_1.setLeftChild(left_1_left);
        left_1.setRightChild(left_1_right);

        right_1.setLeftChild(right_1_left);
        right_1.setRightChild(right_1_right);

        root.setLeftChild(left_1);
        root.setRightChild(right_1);

        Tree<Integer> tree=new Tree<>(root);


        //先序遍历
        tree.preorderTraversal_recursion();
        System.out.println("===============");
        tree.preorderTraversal_loop();

        //中序遍历
        //tree.middleorderTraversal_recursion();

        //后序遍历
        //tree.postorderTraversal_recursion();
    }
}
