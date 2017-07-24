//Refs: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Node<T> {
        T value;
        Node next;
        
        public Node(T value) {
            this.value = value;
        }
    }
    
    public class Stack<T> {
        Node head;
        
        public Stack() {
            head = null;
        }
        
        public Node pop() {
            Node popped = head;
	    if (head != null) head = head.next;
	    return popped;
        }
         
        public void push(Node aNode) {
	    log("Pushing node with value: "+aNode.value);
	    aNode.next = head;
	    head = aNode;
        }
    }
    
    public class MyQueue<T> {
        Stack<T> mainStack;
        Stack<T> tempStack;
        
        public MyQueue() {
            mainStack = new Stack<T>();
            tempStack = new Stack<T>();
        }
        
        public void enqueue(int value) {
            Node<Integer> aNewNode = new Node<Integer>(new Integer(value));
            mainStack.push(aNewNode);
        }
        
        public Object dequeue() {
            return peek(true);
        }
        
        public Object peek() {
            return peek(false);
        }
        
        public Object peek(boolean dequeueRequested) {
	    log("peeking, dequeueRequested: "+dequeueRequested);
            Node someNode = mainStack.pop();
            while (someNode != null) {
		log("Loading tempStack, got: "+someNode.value);
                tempStack.push(someNode);
                someNode = mainStack.pop();
            }
            
            Node frontNode = tempStack.pop();
            if (!dequeueRequested && frontNode != null) { mainStack.push(frontNode); }
            
            //put the nodes back in the mainStack
            someNode = tempStack.pop();
            while (someNode != null) {
                mainStack.push(someNode);
                someNode = tempStack.pop();
            }
            
	    if (frontNode == null) return null;
            return frontNode.value;
        }
        

    }

    public static final boolean DEBUGGING = false; 

    public static void main(String[] args) {
	Solution sol = new Solution();
	sol.execute();
    }

    public void execute() {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static void log(String message) {
	    if (DEBUGGING) System.out.println(message);
    }
}
