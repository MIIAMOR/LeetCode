package com.yubin.priority_queue.basic;

/**
 * @author MIIAMOR
 * @date 2021/6/20
 * <p>
 * 优先的实现
 * 对于i索引的值
 * 他的两个子节点分别对应着2*i和2*i+1(因此空出索引0的值)
 * 且每个节点的值都小于他的两个子节点
 */
public class PriorityQueue<E> {
    // 堆的容量 堆中已经有的数据数量 堆中的数据
    private int capacity;
    private int length;
    private Object[] value;
    // 是最大优先还是最小优先
    public static final boolean MAX_PRIORITY = true;
    public static final boolean MIN_PRIORITY = false;
    private boolean priority = MIN_PRIORITY;// 默认使用最小优先

    /**
     * 无参构造，初始分配得容量为10
     */
    public PriorityQueue() {
        this(10);
    }

    /**
     * 初始化对应容量的堆
     *
     * @param capacity 堆的容量
     */
    public PriorityQueue(int capacity) {
        if (capacity < 1)
            throw new RuntimeException("Too little space allocated");
        this.capacity = capacity;
        length = 0;
        value = new Object[capacity + 1];
    }

    /**
     * 最大优先还是最小优先
     */
    public PriorityQueue(boolean priority) {
        this(10);
        this.priority = priority;
    }

    /**
     * 初始化容量和选择优先方式的构造
     */
    public PriorityQueue(int capacity, boolean priority) {
        this(capacity);
        this.priority = priority;
    }

    /**
     * 向堆中加入一个元素
     */
    public void insert(E e) {
        value[++length] = e;
        if (1.0 * length / capacity > 0.8)
            increaseCapacity();
        //上浮算法：把t放入数组中合适位置
        floatingUp(length);
    }

    /**
     * @return 返回对头，空时返回null
     */
    public E poll() {
        if (length == 0) return null;
        exch(1, length);
        E theValue = (E) value[length--];
        if (1.0 * length / capacity < 0.2) reduceCapacity();
        // 下沉算法，把原本在末尾但现在在对头的元素下沉到合适位置
        sinking(1);
        return theValue;
    }

    public E peek() {
        if (length == 0) return null;
        return (E) value[1];
    }

    /**
     * 下沉算法：把索引i的元素放入合适位置
     */
    private void sinking(int i) {
        boolean flag = false;
        while (true) {
            // 已经到达队列的末尾
            if (2 * i > length) break;
            int left = 2 * i, right = left + 1;
            if (priority) {
                if (left == length) {
                    // right越界 不考虑
                    if (less(i, left)) exch(i, left);
                    flag = true;
                } else {
                    // left和right都没有越界
                    if (less(i, left) || less(i, right)) {
                        if (less(left, right)) {
                            exch(i, right);
                            i = right;
                        } else {
                            exch(i, left);
                            i = left;
                        }
                    } else flag = true;
                }
            } else {
                if (left == length) {
                    // right越界 不考虑
                    if (greater(i, left)) exch(i, left);
                    flag = true;
                } else {
                    // left和right都没有越界
                    if (greater(i, left) || greater(i, right)) {
                        if (greater(left, right)) {
                            exch(i, right);
                            i = right;
                        } else {
                            exch(i, left);
                            i = left;
                        }
                    } else flag = true;
                }
            }
            if (flag) break;
        }
    }

    /**
     * 上浮算法：把索引i的值放入堆中合适位置
     */
    private void floatingUp(int i) {
        boolean flag = false;
        while (true) {
            // 到达根节点，退出
            if (i == 1) break;
            int index = i / 2;// 父亲节点所在的索引
            if (priority) {
                if (less(index, i)) {
                    // 父节点比自己小：交换索引，继续上浮。直到到达出口
                    exch(index, i);
                    i = index;
                } else flag = true;
            } else {
                if (greater(index, i)) {
                    // 父节点比自己大：交换索引，继续上浮。直到到达出口
                    exch(index, i);
                    i = index;
                    continue;
                } else flag = true;
            }
            if (flag) break;
        }
    }

    /**
     * @return 堆中元素的个数
     */
    public int size() {
        return length;
    }

    /**
     * @return 堆是否为空
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 对堆进行扩容
     * 扩容判断条件：添加元素时检查length和capacity的比值
     * 大于0.8则扩容
     */
    private void increaseCapacity() {
        // 每次扩容以两倍扩容
        capacity = 2 * capacity;
        Object[] newValue = new Object[capacity + 1];
        System.arraycopy(value, 1, newValue, 1, length);
        value = newValue;
    }

    /**
     * 对堆进行减容
     * 减容判断条件：添加元素时检查length和capacity的比值
     * 小于于0.2则减容
     */
    private void reduceCapacity() {
        // 每次减容以一半为基准
        int newCapacity = capacity / 2;
        // 减容后容量不足10 不进行减容
        if (newCapacity <= 10) return;
        capacity = newCapacity;
        Object[] newValue = new Object[capacity + 1];
        System.arraycopy(value, 1, newValue, 1, length);
        value = newValue;
    }

    /**
     * 判断i和j索引位置的值的大小
     */
    private <T> boolean less(int i, int j) {
        Object o1 = value[i], o2 = value[j];
        return ((Comparable<T>) o1).compareTo((T) o2) < 0;
    }

    private <T> boolean greater(int i, int j) {
        Object o1 = value[i], o2 = value[j];
        return ((Comparable<T>) o1).compareTo((T) o2) > 0;
    }

    /**
     * 交换i和j索引处的值
     */
    private void exch(int i, int j) {
        Object tmp = value[i];
        value[i] = value[j];
        value[j] = tmp;
    }
}
