package com.bjx;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EnochStar
 * @title: LRUCache
 * @projectName leetcode_study
 * @description: 
 * �����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������� ��
 * ʵ�� LRUCache �ࣺ
 *
 * LRUCache(int capacity) ����������Ϊ���� capacity ��ʼ�� LRU ����
 * int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
 * void put(int key, int value) ����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
 *  
 *
 * ���ף����Ƿ������ O(1) ʱ�临�Ӷ�����������ֲ�����
 *
 *  
 *
 * ʾ����
 *
 * ����
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * ���
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * ����
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // ������ {1=1}
 * lRUCache.put(2, 2); // ������ {1=1, 2=2}
 * lRUCache.get(1);    // ���� 1
 * lRUCache.put(3, 3); // �ò�����ʹ�ùؼ��� 2 ���ϣ������� {1=1, 3=3}
 * lRUCache.get(2);    // ���� -1 (δ�ҵ�)
 * lRUCache.put(4, 4); // �ò�����ʹ�ùؼ��� 1 ���ϣ������� {4=4, 3=3}
 * lRUCache.get(1);    // ���� -1 (δ�ҵ�)
 * lRUCache.get(3);    // ���� 3
 * lRUCache.get(4);    // ���� 4
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/lru-cache
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @date 2021/2/28 11:03
 */
public class LRUCache {
    class DLinkedList{
        private int key;
        private int value;
        private DLinkedList pre;
        private DLinkedList next;
        public DLinkedList() {};
        public DLinkedList(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int size;
    DLinkedList head,tail;
    Map<Integer,DLinkedList> cache = new HashMap();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedList node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedList node = cache.get(key);
        if(node == null) {
            node = new DLinkedList(key,value);
            cache.put(key,node);
            addToHead(node);
            size++;
            if(size > capacity) {
                DLinkedList tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addToHead(node);
    }

    public void addToHead(DLinkedList node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    public DLinkedList removeTail() {
        DLinkedList node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        return node;
    }
}
