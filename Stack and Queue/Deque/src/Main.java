package DEQUE;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(89);
        deque.add(49);
        System.out.println(deque);
        deque.addFirst(10);
        deque.addLast(20);
        System.out.println(deque);

    }
}
