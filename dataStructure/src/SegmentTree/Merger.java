package SegmentTree;

public interface Merger<E> {
    public E merge(E left, E right);
}
