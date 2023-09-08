public class ExpressionParser {
    public static AbstractExpression parseExpression(Context context) {
        // Implement parsing logic to create the AST here.
        // For simplicity, let's assume a fixed expression for this example.
        AbstractExpression number1 = new NumberExpression(5);
        AbstractExpression number2 = new NumberExpression(3);
        AbstractExpression addition = new AdditionExpression(number1, number2);
        AbstractExpression number3 = new NumberExpression(2);
        AbstractExpression multiplication = new MultiplicationExpression(addition, number3);
        return multiplication;
    }

    public static void main(String[] args) {
        String postfixExpression = "5 3 + 2 *"; // Example Postfix expression
        Context context = new Context(postfixExpression);

        AbstractExpression expression = parseExpression(context);

        int result = expression.interpret();
        System.out.println("Result: " + result); // Output: Result: 16
    }
}