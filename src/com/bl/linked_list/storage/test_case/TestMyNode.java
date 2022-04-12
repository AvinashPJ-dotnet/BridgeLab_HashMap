package com.bl.linked_list.storage.test_case;

import com.bl.linked_list.storage.MyNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMyNode {
    @Test
    public void given3NumbersWhenPushToStackShouldPassedStack() {
        MyNode<Object> myFirstNode = new MyNode<>(56);
        MyNode<Object> mySecondNode = new MyNode<>(30);
        MyNode<Object> myThirdNode = new MyNode<>(70);
        myFirstNode.setNext(mySecondNode);
        mySecondNode.setNext(myThirdNode);
        boolean result = myFirstNode.getNext().equals(mySecondNode) &&
                mySecondNode.getNext().equals(myThirdNode);
        Assertions.assertTrue(result);
    }
}
