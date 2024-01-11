import java.util.Stack;
//https://leetcode.com/problems/implement-queue-using-stacks/solutions/

public class Queue_using_Stacks {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        try {
            // Removing and printing elements from the queue
            System.out.println("Removed element: " + queue.remove()); // Output: 10
            System.out.println("Removed element: " + queue.remove()); // Output: 20

            // Adding more elements to the queue
            queue.add(40);
            queue.add(50);

            // Printing the front element of the queue
            System.out.println("Front element: " + queue.peek()); // Output: 30

            // Checking if the queue is empty
            System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false

            // Removing and printing elements from the queue
            System.out.println("Removed element: " + queue.remove()); // Output: 30
            System.out.println("Removed element: " + queue.remove()); // Output: 40

            // Checking if the queue is empty after removing all elements
            System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false

            // Removing the remaining element from the queue
            System.out.println("Removed element: " + queue.remove()); // Output: 50

            // Checking if the queue is empty after removing all elements
            System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        // Adding an element to the queue by pushing it to the first stack
        first.push(item);
    }

    public int remove() throws Exception {
        // Removing and returning the front element of the queue

        // Moving all elements from the first stack to the second stack
        while (!first.isEmpty()) {
            int popped = first.pop();
            second.push(popped);
        }
        // Popping the element from the second stack (which is the front of the queue)
        int removed = second.pop();

        // Moving all elements back from the second stack to the first stack
        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public int peek() throws Exception {
        // Returning the front element of the queue without removing it

        // Moving all elements from the first stack to the second stack
        while (!first.isEmpty()) {
            int popped = first.pop();
            second.push(popped);
        }

        // Peeking at the top element of the second stack (which is the front of the queue)
        int peeked = second.peek();

        // Moving all elements back from the second stack to the first stack
        while (!second.isEmpty()) {
            first.push(second.pop());
        }

        return peeked;
    }

    public boolean isEmpty() {
        // Checking if the queue is empty by checking if the first stack is empty
        return first.isEmpty();
    }
}
