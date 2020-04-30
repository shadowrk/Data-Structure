package SegmentTree;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {1, 3, 5};
        SegmentTree<Integer> segTree = new SegmentTree<Integer>(nums, (a, b) -> a + b);
        long start = System.currentTimeMillis();
        segTree.query(0, 2);
        segTree.set(1, 2);
        segTree.query(0, 2);
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
