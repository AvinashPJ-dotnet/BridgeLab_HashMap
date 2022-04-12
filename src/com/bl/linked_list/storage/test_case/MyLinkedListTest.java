package com.bl.linked_list.storage.test_case;

import com.bl.linked_list.storage.INode;
import com.bl.linked_list.storage.MyLinkedList;
import com.bl.linked_list.storage.MyNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    @Test
    public void given3NumbersWhenAddedToLinkedListShouldAddedToTop() {
        MyNode<Object> myFirstNode = new MyNode<>(70);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(56);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.add(mySecondNode);
        myLinkedList.add(myThirdNode);
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(myThirdNode) &&
                myLinkedList.tail.equals(myFirstNode);
        Assertions.assertTrue(result);
    }

    @Test
    public void given3NumbersWhenAddedToLinkedListShouldAddedToEnd() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(myFirstNode) &&
                myLinkedList.tail.equals(myThirdNode);
        Assertions.assertTrue(result);
    }

    //UC4: insert between given node
    @Test
    public void given3NumbersWhenInsertSecondInBetweenShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.printMyNode();
        myLinkedList.insert(myFirstNode, mySecondNode);
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(myFirstNode) &&
                myLinkedList.head.getNext().equals(mySecondNode) &&
                myLinkedList.tail.equals(myThirdNode);
        Assertions.assertTrue(result);
    }

    //UC5: pop first element
    @Test
    public void given3NumbersWhenPopFirstElementDeleteShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.printMyNode();
        myLinkedList.pop();
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(mySecondNode) &&
                myLinkedList.head.getNext().equals(myLinkedList.tail);

        Assertions.assertTrue(result);
    }

    //UC6: popLast element
    @Test
    public void given3NumbersWhenPopLastElementDeleteShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.printMyNode();
        myLinkedList.popLast();
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(myFirstNode) &&
                myLinkedList.head.getNext().equals(mySecondNode);

        Assertions.assertTrue(result);
    }

    //UC7: Search element
    @Test
    public void given3NumbersWhenSearchElementGetShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
//        int pos = myLinkedList.search(mySecondNode);
        INode pos = myLinkedList.search(30);
        myLinkedList.printMyNode();
        System.out.println(pos);
//        boolean result = myLinkedList.head.equals(myFirstNode) &&
//                myLinkedList.head.getNext().equals(mySecondNode);
//
//        Assertions.assertTrue(result);
    }


    //UC8: delete/remove specific element
    @Test
    public void given3NumbersWhenDeleteSpecificElementGetShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(40);
        MyNode<Object> myForthNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.append(myForthNode);

        myLinkedList.remove(myForthNode);
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(myFirstNode) &&
                myLinkedList.head.getNext().equals(mySecondNode) &&
                myLinkedList.tail.equals(myThirdNode);

        Assertions.assertTrue(result);
    }


    //UC8: delete/remove First element
    @Test
    public void given3NumbersWhenDeleteSpecificFirstElementGetAndSizeMust3AnsSearchElementFoundShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(40);
        MyNode<Object> myForthNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.append(myForthNode);

//        int pos = myLinkedList.search(myFirstNode);
        myLinkedList.remove(myFirstNode);
        int size = myLinkedList.size();
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(mySecondNode) &&
                myLinkedList.head.getNext().equals(myThirdNode) &&
                myLinkedList.tail.equals(myForthNode) && size == 3 ;

        Assertions.assertTrue(result);
    }


    //UC8: delete/remove First element
    @Test
    public void given3NumbersWhenDeleteSpecificMiddleElementGetShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(40);
        MyNode<Object> myForthNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.append(myForthNode);
        myLinkedList.printMyNode();

//        int pos = myLinkedList.search(mySecondNode);
        myLinkedList.remove(mySecondNode);
        myLinkedList.remove(myThirdNode);

        int size = myLinkedList.size();
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(myFirstNode) &&
                myLinkedList.tail.equals(myForthNode) && size == 2 ;

        Assertions.assertTrue(result);
    }

    //UC10: insert sorted list
    @Test
    public void given4NumbersWhenAddSortedListShouldPassLinkedListResult() {
        MyNode<Object> myFirstNode = new MyNode<>(50);
        MyNode<Object> mySecondNode = new MyNode<>(40);
        MyNode<Object> myThirdNode = new MyNode<>(30);
        MyNode<Object> myForthNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addSortedList(myFirstNode);
        myLinkedList.addSortedList(mySecondNode);
        myLinkedList.addSortedList(myThirdNode);
        myLinkedList.addSortedList(myForthNode);
        myLinkedList.printMyNode();
        boolean result = myLinkedList.head.equals(myThirdNode) &&
                myLinkedList.tail.equals(myForthNode);

        Assertions.assertTrue(result);
    }
}
