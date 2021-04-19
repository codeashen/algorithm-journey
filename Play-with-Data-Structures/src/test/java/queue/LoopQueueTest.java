package queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoopQueueTest {

    @Test
    public void enqueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
    }

    @Test
    public void dequeue() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
        for (int i = 0; i < 10; i++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
    }
}