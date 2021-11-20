

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(7);
        stack.push(4);
        stack.push(2);
        System.out.println(stack);

        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);





    }
}
