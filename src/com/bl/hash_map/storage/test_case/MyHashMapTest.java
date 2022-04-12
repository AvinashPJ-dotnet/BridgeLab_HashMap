package com.bl.hash_map.storage.test_case;

import com.bl.hash_map.storage.MyHashMap;
import com.bl.hash_map.storage.MyMapNode;
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
}
