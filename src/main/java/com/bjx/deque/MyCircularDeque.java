package com.bjx.deque;

/**
 * @author EnochStar
 * @title: CirculateDeque
 * @projectName leetcode_study
 * @description: 
 * ���ʵ��˫�˶��С�
 * ���ʵ����Ҫ֧�����²�����
 *
 * MyCircularDeque(k)�����캯��,˫�˶��еĴ�СΪk��
 * insertFront()����һ��Ԫ����ӵ�˫�˶���ͷ���� ��������ɹ����� true��
 * insertLast()����һ��Ԫ����ӵ�˫�˶���β������������ɹ����� true��
 * deleteFront()����˫�˶���ͷ��ɾ��һ��Ԫ�ء� ��������ɹ����� true��
 * deleteLast()����˫�˶���β��ɾ��һ��Ԫ�ء���������ɹ����� true��
 * getFront()����˫�˶���ͷ�����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1��
 * getRear()�����˫�˶��е����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1��
 * isEmpty()�����˫�˶����Ƿ�Ϊ�ա�
 * isFull()�����˫�˶����Ƿ����ˡ�
 * ʾ����
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // ����������СΪ3
 * circularDeque.insertLast(1);			        // ���� true
 * circularDeque.insertLast(2);			        // ���� true
 * circularDeque.insertFront(3);			        // ���� true
 * circularDeque.insertFront(4);			        // �Ѿ����ˣ����� false
 * circularDeque.getRear();  				// ���� 2
 * circularDeque.isFull();				        // ���� true
 * circularDeque.deleteLast();			        // ���� true
 * circularDeque.insertFront(4);			        // ���� true
 * circularDeque.getFront();				// ���� 4
 * 
 * 
 *
 * ��ʾ��
 *
 * ����ֵ�ķ�ΧΪ [1, 1000]
 * ���������ķ�ΧΪ [1, 1000]
 * �벻Ҫʹ�����õ�˫�˶��п⡣
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/design-circular-deque
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/1/31 19:50
 */
public class MyCircularDeque {
    int[] arr;
    int head;
    int tail;
    int capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + capacity) % capacity;
        arr[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        head = (head + 1) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        tail = (tail - 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(tail - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return tail == head;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}
