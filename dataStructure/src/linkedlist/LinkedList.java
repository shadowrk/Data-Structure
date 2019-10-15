package linkedlist;

/**
 * 此类中使用index的地方，index为从0开始的索引，而不是第index个元素的地方
 * @param <E>
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    /**
     * head 虚拟头结点
     * size 链表大小
     */
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 在链表index[0, size)处添加元素e
     * 一般使用链表时，不使用此方法
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add Failed. Illegal index");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;

        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size ++;
    }
    /**
     * 在链表头添加新元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在链表末尾添加元素e
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获取链表index[0, size)处的元素
     * 此方法一般不用，练习用
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get Failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;

        }
        return cur.e;
    }

    /**
     * 获取链表第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改index[0, size)位置的元素值
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set Failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e == e)
                return true;
            cur = cur.next;

        }
        return false;

    }

    /**
     * 从列表中删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove Failed. Illegal index.");
        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size --;

        return cur.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }
    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();

    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        System.out.println(linkedList.get(4));

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

}
