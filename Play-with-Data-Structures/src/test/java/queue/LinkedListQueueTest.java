package queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListQueueTest {

    @Test
    public void enqueue() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.getSize());
        assertEquals(0, (int) queue.getFront());
        System.out.println(queue);

        Integer delElement = queue.dequeue();
        assertEquals(0, (int) delElement);
        System.out.println(queue);
    }

    @Test
    public void dequeue() {
    }
}