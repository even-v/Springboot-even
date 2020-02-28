package cn.even.dataStructure.stack;


public class MyStack<T> {

    /**
     * 默认栈空间
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 栈空间
     */
    private transient Object[] elementData;

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 栈修改次数
     */
    private int modCount;

    /**
     * 栈元素个数
     */
    private int size;

    public MyStack() {
        this.elementData = EMPTY_ELEMENTDATA;
    }


    /**
     * 抛出栈顶元素，若栈中没有元素返回null
     *
     * @return 返回栈顶元素
     */
    public T pop() {
        if (size == 0) {
            return null;
        }
        return (T) elementData[--size];
    }

    /**
     * 将元素压入栈中
     *
     * @param t 元素
     * @return 压入栈的元素
     */
    public T push(T t) {
        modCount++;
        addElement(t);
        return t;
    }

    /**
     * 增加元素
     *
     * @param t 元素
     */
    private void addElement(T t) {
        grow();
        elementData[size++] = t;
    }


    /**
     * 增长空间
     */
    private void grow() {
        if (elementData.length == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
            return;
        }
        if (elementData.length - size < 2) {//增加容量
            Object[] desc = new Object[elementData.length << 1];
            System.arraycopy(elementData, 0, desc, 0, elementData.length - 1);
            elementData = desc;
        }
    }

}
