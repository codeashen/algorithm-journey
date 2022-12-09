package linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    @Test
    public void add() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
            if (i == 4) {
                linkedList.add(1, i);
            }
            System.out.println(linkedList);
        }
        
        linkedList.set(1, 20);
        System.out.println(linkedList);

        assertTrue(linkedList.contains(20));
    }

    @Test
    public void addFirst() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        System.out.println(linkedList.getSize());
    }

    @Test
    public void remove() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
    }

    @Test
    public void removeElements() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            linkedList.addLast(new Random().nextInt(3));
        }
        System.out.println(linkedList);

        linkedList.removeElements(1);
        assertFalse(linkedList.contains(1));
        System.out.println(linkedList);
    }
}