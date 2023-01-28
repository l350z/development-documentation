package cn.jbit.datastructure.util;

public interface LinearList<E> {
    boolean isEmpty();//判断线性表是否为空
    int size();//返回线性表长度
    E get(int index);//返回索引为index的对象
    E set(int index, E element);//用指定元素替换线性表中指定位置的元素
    boolean add(int index, E element);//在线性表的指定位置插入指定元素
    boolean add(E element);//向线性表的尾部添加指定的元素
    E remove(int index);//移除线性表中指定位置的元素
    void clear();//从线性表中移除所有元素
}
