package array.template;

public class Array<E> {

    private E[] data;
    //数组中元素个数
    private int size;
    /**
     * 构造函数，传入数组容量capacity构造数组
     * @param capacity  数组容量
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    /**
     * 无参数构造函数，默认容量capacity=10
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加新元素
     * @param e
     */
    public void addLast(E e){
//        if(size == data.length)
//            throw new IllegalArgumentException("AddLast failed, Array is full");
//        data[size] = e;
//        size ++;
        add(size, e);
    }
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在index位置添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(size == data.length)
            resize(2 * data.length);

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Require index >= 0 and index < size");

        for(int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;

    }

    /**
     * 数组扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }
    public E getLast(){
        return get(size - 1);
    }
    public E getFirst(){
        return get(0);
    }
    /**
     * 修改index位置元素
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        data[index] = e;
    }

    /**
     * 数组是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    /**
     *
     * @param e
     * @return 查找元素e所在的位置，若不存在，则返回-1
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 从数组中删除index位置元素，返回删除元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed, Index is Illegal");
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size --;
        data[size] = null;
        if(size == data.length / 2){
            resize(data.length / 2);
        }
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size -1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }
}

