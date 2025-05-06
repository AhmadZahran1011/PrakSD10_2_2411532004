package pekan3;

import java.util.Stack;
import java.util.Scanner;


public class StackPostFix {

    public static int postfixEvaluate(String expression) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner input = new Scanner(expression);

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                // Operand (bilangan bulat)
                s.push(input.nextInt());
            } else {
                // Operator
                String operator = input.next();
                int operand2 = s.pop();
                int operand1 = s.pop();

                if (operator.equals("+")) {
                    s.push(operand1 + operand2);
                } else if (operator.equals("-")) {
                    s.push(operand1 - operand2);
                } else if (operator.equals("*")) {
                    s.push(operand1 * operand2);
                } else {
                    s.push(operand1 / operand2);
                }
            }
        }

        return s.pop();  // Hasil akhir evaluasi postfix
    }

    public static void main(String[] args) {
        System.out.println("Hasil postfix = " + postfixEvaluate("5 2 5 + 7 -"));
    }
}
