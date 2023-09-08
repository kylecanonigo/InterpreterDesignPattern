import java.util.Stack;

public class ExpressionParser {
    public static AbstractExpression parseExpression(Context context) {
        String postfixExpression = context.getExpression();

        // Tokenize the input expression
        String[] tokens = postfixExpression.split("\\s+");

        Stack<AbstractExpression> stack = new Stack<>();

        for(String token : tokens) {
            if (isNumber(token)) {
                stack.push(new NumberExpression(Integer.parseInt(token)));
            } else if (isOperator(token)) {
                // Pop the top two expressions from the stack
                AbstractExpression right = stack.pop();
                AbstractExpression left = stack.pop();

                // Create a binary expression based on the operator
                if (token.equals("+")) {
                    stack.push(new AdditionExpression(left, right));
                } else if (token.equals("-")) {
                    stack.push(new SubtractionExpression(left, right));
                } else if (token.equals("*")) {
                    stack.push(new MultiplicationExpression(left, right));
                }
            }
        }

        // The remaining expression on the stack is the result
        return stack.pop();
    }

    public static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    public static void main(String[] args) {
        String postfixExpression = "5 3 + 2 *"; // Example Postfix expression
        Context context = new Context(postfixExpression);

        AbstractExpression expression = parseExpression(context);

        int result = expression.interpret();
        System.out.println("Result: " + result); // Output: Result: 16
    }
}