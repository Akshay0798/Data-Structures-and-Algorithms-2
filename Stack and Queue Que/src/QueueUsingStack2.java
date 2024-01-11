import java.util.Stack;
//https://leetcode.com/problems/implement-queue-using-stacks/solutions/

public class QueueUsingStack2 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Pushing elements to the queue
        queue.push(10);
        queue.push(20);
        queue.push(30);

        // Printing the front element
        System.out.println("Front element: " + queue.peek()); // Output: 10

        // Removing and printing elements
        System.out.println("Removed element: " + queue.pop()); // Output: 10
        System.out.println("Removed element: " + queue.pop()); // Output: 20

        // Checking if the queue is empty
        System.out.println("Is queue empty? " + queue.empty()); // Output: false

        // Removing the remaining element
        System.out.println("Removed element: " + queue.pop()); // Output: 30

        // Checking if the queue is empty after removing all elements
        System.out.println("Is queue empty? " + queue.empty()); // Output: true
    }
}

class MyQueue {
    public Stack<Integer> first = new Stack<>();
    public Stack<Integer> second = new Stack<>();

    public MyQueue() {
        // Constructor for the MyQueue class.
    }

    public void push(int x) {
        // Pushes an element to the queue.

        // Moving all elements from the first stack to the second stack.
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        // Pushing the new element to the first stack.
        first.push(x);

        // Moving all elements back from the second stack to the first stack.
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int pop() {
        // Removes and returns the front element of the queue.

        if (!first.isEmpty()) {
            return first.pop();
        }

        // If the queue is empty, return -1 or throw an exception based on the requirement.
        return -1;
    }

    public int peek() {
        // Returns the front element of the queue without removing it.

        if (!first.isEmpty()) {
            return first.peek();
        }

        // If the queue is empty, return -1 or throw an exception based on the requirement.
        return -1;
    }

    public boolean empty() {
        // Checks if the queue is empty.

        return first.isEmpty();
    }
}
