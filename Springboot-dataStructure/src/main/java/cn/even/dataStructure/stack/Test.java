package cn.even.dataStructure.stack;

public class Test {
    public static void main(String [] args){
        MyStack<Integer> stack=new MyStack<>();
        for (int i=0;i<=39;i++){
            stack.push(i);
        }

        System.out.println(stack.pop());
    }
}
