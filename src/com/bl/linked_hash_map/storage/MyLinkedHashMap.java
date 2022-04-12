package com.bl.linked_hash_map.storage;

import com.bl.hash_map.storage.MyMapNode;
import com.bl.linked_list.storage.MyLinkedList;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
    private final int noOfBucket;
    private final ArrayList<MyLinkedList<K>> myBucketArray;

    public MyLinkedHashMap() {
        this.noOfBucket = 10;
        this.myBucketArray = new ArrayList<>(noOfBucket);
        for (int i = 0; i < noOfBucket; i++) {
            this.myBucketArray.add(null);
        }
    }

    public int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % noOfBucket;
        return index;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        int index = getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            this.myBucketArray.set(index, myLinkedList);
        }
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.append(myMapNode);
        } else myMapNode.setValue(value);
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList != null) {
            MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
            myLinkedList.remove(myMapNode);
        }
        this.myBucketArray.set(index, null);
    }

    @Override
    public String toString() {
        return "MyLinkedHashMapNodes{ " + myBucketArray.toString() + " }";
    }
}
