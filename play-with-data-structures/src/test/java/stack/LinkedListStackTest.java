package stack;

import org.junit.jupiter.api.Test;

public class LinkedListStackTest {

    @Test
    public void push() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        for (int i = 0; i < 3; i++) {
            stack.pop();
        }
        System.out.println(stack);
    }

    @Test
    public void pop() {
    }
}