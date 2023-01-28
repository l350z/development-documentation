package cn.jbit.datastructure.util;

public class DoubleNode<T> {
    public T nodeValue;

    public DoubleNode<T> prev;
    public DoubleNode<T> next;

    public DoubleNode()
    {
       nodeValue = null;
       next = this;
       prev = this;
    }

    public DoubleNode(T item)
    {
       nodeValue = item;
       next = this;   // the next node is the current node
       prev = this;   // the previous node is the current node
    }
}
