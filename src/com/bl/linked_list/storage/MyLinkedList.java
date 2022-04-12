package com.bl.linked_list.storage;

public class MyLinkedList<K> {
    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null)
            this.tail = newNode;
        if (this.head == null)
            this.head = newNode;
        else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void append(INode newNode) {
        if (head == null)
            head = newNode;
        if (tail == null)
            tail = newNode;
        else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public void addSortedList(INode newNode) {
        INode current;

        if (head == null) {
            newNode.setNext(null);
            head = newNode;
            return;
        }
        if (head.getKey().toString().compareTo(newNode.getKey().toString()) >= 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            current = head;
            while (current.getNext() != null && current.getNext().getKey().toString().compareTo(newNode.getKey().toString()) <= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            tail = newNode;
        }
    }

    public INode pop() {
        INode tempNode = head;
        head = head.getNext();
        return tempNode;
    }

    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(null);
        this.tail = tempNode;
        return tail;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void remove(INode removeNode) {
        INode tempNode = head;
        if (tempNode != null && tempNode == removeNode) {
            head = tempNode.getNext(); // Changed head
            return;
        }
        while (tempNode != null && tempNode.getNext() != removeNode) {
            tempNode = tempNode.getNext();
        }
        if (tempNode == null)
            return;
        if (tempNode.getNext().getNext() == null) {
            tempNode.setNext(null);
            tail = tempNode; // tail changed
            return;
        }
        tempNode.setNext(tempNode.getNext().getNext());
    }

    public INode search(K searchKey) {
        INode tempNode = head;
        while (tempNode != null) {
            if (tempNode.getKey().equals(searchKey))
                return tempNode;
            tempNode = tempNode.getNext();
        }
        return null;
    }

    public int size() {
        INode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void printMyNode() {
        StringBuffer myNode = new StringBuffer("My Node: ");
        INode tempNode = head;

        if (head == null) {
            return;
        }
        while (tempNode.getNext() != null) {
            myNode.append(tempNode.getKey());
            if (!tempNode.equals(tail))
                myNode.append("->");
            tempNode = tempNode.getNext();
        }
        myNode.append(tempNode.getKey());
        System.out.println(myNode);
    }
}
