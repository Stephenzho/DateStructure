package stack_queue;

import java.util.Stack;

/**
 * @author zhoushuyi
 * @since 2018/6/10
 */
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            char ca =  s.charAt(i);
            if (ca == '{' || ca == '[' || ca == '('){
                stack.push(ca);
            }else{
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if (top =='[' && ca!=']'){
                    return false;
                }
                if (top == '{' && ca!= '}'){
                    return false;
                }
                if (top == '(' && ca != ')') {
                    return false;
                }

                stack.pop();
            }

        }


        return stack.isEmpty() ? true : false;
    }


    public static void main(String[] qwer){


    }

}