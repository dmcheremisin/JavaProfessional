package $03GenericsAndCollections.queueStack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        System.out.println(stack); // [1, 2]
        // push works the same way as add(E)
        stack.push("3");
        stack.push("4");
        System.out.println(stack);// [1, 2, 3, 4]
        System.out.println(stack.peek()); // 4
        System.out.println(stack.peek()); // 4
        System.out.println(stack.pop());  // 4
        System.out.println(stack); // [1, 2, 3]

        stack.add(0, "5");
        System.out.println(stack); // [5, 1, 2, 3]
        System.out.println(stack.get(1)); // 1
    }
}
