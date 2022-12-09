package array;


import org.junit.jupiter.api.Test;

public class ArrayTest {
    @Test
    public void add() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(17, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.addLast(2000);
        System.out.println(arr);
    }

    @Test
    public void set() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        arr.set(10, 1010);
        System.out.println(arr.get(10));
    }

    @Test
    public void contains() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.contains(1));
        System.out.println(arr.find(16));
    }

    @Test
    public void remove() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.remove(10);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
    }

    @Test
    public void removeElement() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.removeElement(101));
        System.out.println(arr);
    }

    @Test
    public void resize() {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 100; i++) {
            arr.addLast(i);
            System.out.println(arr);
        }
        for (int i = 0; i < 100; i++) {
            arr.removeLast();
            System.out.println(arr);
        }
    }

    @Test
    public void removeLast() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        for (int i = 0; i < 17; i++) {
            arr.removeLast();
        }
        for (int i = 0; i < 17; i++) {
            arr.addLast(i);
        }
        for (int i = 0; i < 17; i++) {
            arr.removeLast();
        }
    }
}
