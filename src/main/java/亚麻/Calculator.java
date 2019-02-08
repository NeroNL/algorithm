package 亚麻;

import java.util.Stack;


/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class Calculator {

    public int calculate(String s) {
        int ret = 0;

        if (s == null || s.isEmpty()) return ret;

        Stack<Integer> stack = new Stack<>();

        char sign = '+';

        int num = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10 + c - '0';
            }

            if (!Character.isDigit(c) && ' ' != c || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push((-num));
                }

                if (sign == '+') {
                    stack.push(num);
                }

                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }

                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = s.charAt(i);
                num = 0;
            }
        }

        while(!stack.isEmpty()) {
            ret += stack.pop();
        }

        return ret;
    }

}
