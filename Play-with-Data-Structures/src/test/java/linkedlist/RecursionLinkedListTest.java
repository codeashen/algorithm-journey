package linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionLinkedListTest {

    @Test
    public void add() {
        RecursionLinkedList<Integer> list = new RecursionLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(9);
        list.addLast(10);
        list.add(1, 0);
        System.out.println(list);
        System.out.println(list.getSize());
    }

    @Test
    public void get() {
        RecursionLinkedList<Integer> list = new RecursionLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(5));
    }

    @Test
    public void set() {
        RecursionLinkedList<Integer> list = new RecursionLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list);
        list.set(5, 999);
        System.out.println(list);
    }

    @Test
    public void contains() {
        RecursionLinkedList<Integer> list = new RecursionLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list.contains(0));
        System.out.println(list.contains(9));
        System.out.println(list.contains(5));
        System.out.println(list.contains(100));
    }
    
    @Test
    public void removeTest() {
        RecursionLinkedList<Integer> list = new RecursionLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list);
        Integer first = list.removeFirst();
        Integer last = list.removeLast();
        Integer delElement = list.remove(5);
        System.out.println(list);
    }

    @Test
    public void removeElements() {
    }
}