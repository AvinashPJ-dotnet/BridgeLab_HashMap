package com.bl.hash_map.storage.test_case;

import com.bl.hash_map.storage.MyHashMap;
import com.bl.hash_map.storage.MyMapNode;
import com.bl.linked_hash_map.storage.MyLinkedHashMap;
import com.bl.linked_list.storage.INode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {

    @Test
    public void giveASentence_ShouldCreateMapAndPassTheResult() {
        String sentence = "to be or not to be";
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashMap.get(word);
            if (value == null) value = 1;
            else value = value + 1;
            myHashMap.add(word, value);
        }
        int frequency = myHashMap.get("not");
        System.out.println(myHashMap.toString());
        Assertions.assertEquals(1, frequency);
    }

    //UC2 Linked hash map
    @Test
    public void giveASentence_ShouldCreateMapAndCheckFrequencyOfWordPassTheResult() {
        String sentence = "Paranoids are not paranoid because they are paranoid " + "but because they keep putting themselves deliberately" + " into paranoid avoidable situations";
        MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null) value = 1;
            else value = value + 1;
            myLinkedHashMap.add(word, value);
        }
        int frequency = myLinkedHashMap.get("paranoid");
        System.out.println(myLinkedHashMap);
        Assertions.assertEquals(3, frequency);
    }
}
