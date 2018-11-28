package leetcodeContest112;

import java.util.Stack;


/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 *
 *
 *
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 *
 * Note:
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 */
public class validateStackSequences {


    /**
     * ~ 12ms
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0, j = 0;

        while (j < popped.length) {
            int pop = popped[j];
            if (i < pushed.length && !stack.contains(pop)) {
                while (i < pushed.length && pushed[i] != pop) {
                    stack.push(pushed[i++]);
                }
                if (i < pushed.length) {
                    ++i;
                    ++j;
                }
            } else {
                if (!stack.isEmpty() && stack.pop() != pop) {
                    return false;
                }
                ++j;
            }

        }
        return true;
    }


    /**
     *  ~ 5ms
     * @param pushed
     * @param popped
     * @return
     */
    public boolean solve(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int index = 0, pIndex = 0;

        for (int i = 0; i < pushed.length; ++i) {
            stack[index++] = pushed[i];
            while (index != 0 && stack[index-1] == popped[pIndex]) {
                --index;
                ++pIndex;
            }
        }

        while (index != 0 && stack[index-1] == popped[pIndex]) {
            --index;
            ++pIndex;
        }

        return index == 0 && pIndex == pushed.length;
    }
}