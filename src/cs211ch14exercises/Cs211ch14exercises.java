/*
 * Chapter 14 exercises
 * Created by David Johnson, October 28, 2017
 * for CS211 course, Bellevue College
 */
package cs211ch14exercises;

// Purposely not importing java.util.* to force use of internal Stack class
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Cs211ch14exercises {

    public static void main(String[] args) {
        Stack<Integer> numbersStack = new Stack<>();
        Queue<Integer> numbersQueue = new LinkedList<>();
        Random rand = new Random();
        
        for (int i = 1; i <= 10; i++) {
            numbersStack.push(rand.nextInt(100));
        }
        System.out.println("Initial Stack: " + numbersStack);
        numbersQueue = stackToQueue(numbersStack);
        System.out.println("Stack moved to queue: " + numbersQueue);
        // We have to do this twice to preserver the original order of the stack
        numbersStack = queueToStack(numbersQueue);
        numbersQueue = stackToQueue(numbersStack);
        numbersStack = queueToStack(numbersQueue);
        System.out.println("Queue moved back to stack: " + numbersStack);
        numbersStack = stutter(numbersStack);
        System.out.println("Stuttered stack: " + numbersStack);
    }
    
    // Exercise 2
    // Replaces every value in the stack with two occurrences of that value
    // Preserves original relative order
    // Uses a single queue as auxiliary storage
    public static Stack<Integer> stutter(Stack<Integer> numbers) {
        Queue<Integer> temp = new LinkedList<>();
        Stack<Integer> returnStack = new Stack<>();
        
        // Pull numbers out of the stack and double them in a queue
        while (!(numbers.size() == 0)) {
            int n = numbers.pop();
            temp.add(n);
            temp.add(n);
        }
        
        // Now put the numbers back into the stack
        while (!temp.isEmpty()) {
            returnStack.push(temp.remove());
        }
        
        // But they're backwards, so we must reverse the order
        temp = stackToQueue(returnStack);
        returnStack = queueToStack(temp);
        
        return returnStack;
    }
    
    // Exercise 5
    // Returns true if the two stacks store exactly the same sequence of integer values in the same order
    // Uses a single stack as auxiliary storage
    public static boolean equals(Stack<Integer> numbers1, Stack<Integer> numbers2) {
        return true;
    }
    
    // Exercise 6
    // Reorders values such that all even values appear before odd values
    // Otherwise preserver original order
    // Uses one stack as auxiliary storage
    public static void rearrange(Queue<Integer> numbers) {
        
    }
    
    // Exercise 7
    // Reverses the order of the odd indexed numbers
    // Uses a single stack as auxiliary storage
    public static void reverseHalf(Queue<Integer> numbers) {
        
    }
    
    // Exercise 8
    // Returns true if the numbers in the queue are the same in reverse order
    // Uses one stack as auxiliary storage
    public static boolean isPallindrome(Queue<Integer> numbers) {
        return true;
    }
    
    // Exercise 15
    // Returns true if stack is sorted in ascending order from top to bottom
    // Uses one stack OR queue as auxiliary storage
    public static boolean isSorted(Stack<Integer> numbers) {
        return true;
    }
    
    // Exercise 16
    // Replaces the stack contents with itself plus a mirrored version of itself
    // Uses one stack OR one queue as auxiliary storage
    public static void mirror(Stack<Integer> numbers) {
        
    }
    
    // Exercise 17
    // Replaces each sequence of duplicates with a pair of values:
    // a count of the number of duplicates followed by the actual number
    // Uses one queue as auxiliary storage
    public static void compressDuplicates(Stack<Integer> numbers) {
        
    }
    
    // Exercise 18
    // Replaces each half of the queue with itself, plus a mirrored version of itself
    // Uses one stack OR queue as auxiliary storage
    public static void mirrorHalves(Queue<Integer> numbers) {
        
    }
    
    // Exercise 19
    // Removes and returns the smallest value in the stack
    // Uses one queue as auxiliary storage
    public static int removeMin(Stack<Integer> numbers) {
        return 0;
    }
    
    // Helper methods
    public static Queue stackToQueue(Stack<Integer> numbersStack) {
        Queue<Integer> numbersQueue = new LinkedList<>();
        
        while (!(numbersStack.size() == 0)) {
            numbersQueue.add(numbersStack.pop());
        }
        
        return numbersQueue;
    }
    
    public static Stack queueToStack(Queue<Integer> numbersQueue) {
        Stack<Integer> numbersStack = new Stack<>();
        
        while (!numbersQueue.isEmpty()) {
            numbersStack.push(numbersQueue.remove());
        }
        
        return numbersStack;
    }
}
