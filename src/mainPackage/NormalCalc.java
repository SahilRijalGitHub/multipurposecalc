package mainPackage;

import java.util.Stack;

public class NormalCalc {

    public static float doOperation(char operation,
                                    float operand2, float operand1) {
        return switch (operation) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            default -> 0;
        };
    }

    public static boolean doesProceed(char operation1, char operation2)
    {
        if (operation2 == '(' || operation2 == ')') {
            return false;
        }
        return (operation1 != '*' && operation1 != '/')
                || (operation2 != '+' && operation2 != '-');
    }

    public static float evaluateExpression(String expression) {
        for (int i = 0; i < expression.length(); i = i + 1){
            try {
                if ((expression.charAt(i) == '-')
                        && (expression.charAt(i - 1) == '(')) {
                    expression = expression.substring(0, i)
                            + '0' + expression.substring(i);
                }
            }
            catch(Exception ignored){
            }
        }
        char[] elements = expression.toCharArray();
        Stack<Float> values = new Stack<Float>();
        Stack<Character> operations = new Stack<Character>();

        for (int index = 0; index < elements.length; index = index + 1) {

            if (elements[index] >= '0' && elements[index] <= '9') {
                StringBuilder stringBuilder = new StringBuilder();

                while (index < elements.length
                        && ((elements[index] >= '0' && elements[index] <= '9')
                        || (elements[index] == '.'))) {
                    stringBuilder.append(elements[index]);
                    index = index + 1;
                }
                values.push(Float.parseFloat(stringBuilder.toString()));
                index = index - 1;
            }

            else if (elements[index] == '(')
                operations.push(elements[index]);

            else if (elements[index] == ')') {
                while (operations.peek() != '('){
                    if (values.size() >= 2){
                    values.push(doOperation(operations.pop(),
                            values.pop(), values.pop()));
                    }
                    else{
                        System.out.println("Here 1 " + operations.peek());
                        if (operations.peek() == '-') {
                            values.push(doOperation(operations.pop(),
                                    values.pop(), 0));
                        }

                    }
                }
                operations.pop();
            }

            else if (elements[index] == '+'
                    || elements[index] == '-'
                    || elements[index] == '*'
                    || elements[index] == '/') {

                while (!operations.empty()
                        && doesProceed(elements[index], operations.peek())) {
                    if (values.size() >= 2){
                        values.push(doOperation(operations.pop(),
                                values.pop(), values.pop()));
                    }
                    else {
                        System.out.println("Here 2 " + operations.peek());
                        if (operations.peek() == '-') {
                            values.push(doOperation(operations.pop(),
                                    values.pop(), 0));
                        }
                    }
                }
                operations.push(elements[index]);
            }
        }

        while (!operations.empty()){
            if (values.size() >= 2) {
                values.push(doOperation(operations.pop(),
                        values.pop(), values.pop()));
            }
            else{
                System.out.println("Here 3 " + operations.peek());
                if (operations.peek() == '-') {
                    values.push(doOperation(operations.pop(),
                            values.pop(), 0));
                }
            }
        }
        return values.pop();
    }
}
