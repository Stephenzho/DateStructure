package stack_queue;

/**
 * @author zhoushuyi
 * @since 2018/6/10
 */
public class StackTest {

    public static void main(String[] qwerqwer) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }

        System.out.println(stack);


        stack.pop();

        System.out.println(stack);

        System.out.println(stack.peek());


    }

}
