package 亚麻;

import java.util.Stack;

public class StringEvaluation {

    Stack<String> stack = new Stack<>();
    Stack<Integer> nums = new Stack<>();

    private int getDigit(String s, int i) {
        int res = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res*10 + (s.charAt(i) - '0');
        }
        return res;
    }

    private String getOperator(String s, int i) {
        String cur = "";

        while (i < s.length() && Character.isLetter(s.charAt(i))) {
            cur += s.charAt(i);
            ++i;
        }
        return cur;
    }

    private String getFromStack(){
        if (stack.isEmpty()) {
           return "";
        }
        return stack.pop();
    }

    private int getFromStackInt(){
        if (!nums.isEmpty()) {
           return 0;
        }
        return nums.pop();
    }

    public int eval(String s){

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            String cur = "";
            if (Character.isDigit(c)) {
                nums.push(getDigit(s, i));
            } else if (Character.isLetter(c)) {
                stack.push(getOperator(s, i));
            } else if (c == ')') {
                String operator = getFromStack();
                Integer a = getFromStackInt(), b = getFromStackInt();
                if (operator.equals("mul")) {
                    nums.push(a*b);
                } else if (operator.equals("add")) {
                    nums.push(a+b);
                } else {
                    nums.push(0);
                }
            }
        }

        return nums.isEmpty() ? -1 : nums.pop();
    }


    public static void main(String[] args){
        String s = "(mul ( add 2 3 ) 4)";
        StringEvaluation stringEvaluation = new StringEvaluation();

        System.out.println(stringEvaluation.eval(s));


    }

}
