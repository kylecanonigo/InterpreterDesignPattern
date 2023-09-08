public class MultiplicationExpression extends AbstractExpression {
    private AbstractExpression left;
    private AbstractExpression right;

    public MultiplicationExpression(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}