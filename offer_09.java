import java.util.Stack;

public class offer_09 {
    /**
     * 剑指 Offer 09. 用两个栈实现队列
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     * 解法：
     *      两个栈互相导，
     *      一个栈接收元素，直接入栈
     *      需要删除队首时，将第一个栈元素都出栈，入栈到第二个栈，第二个栈栈顶即为队首
     *      每次删除先判断第二个栈是否为空，不为空直接返回第二栈顶即可。
     *      如果一二都为空，则返回-1。
     *      二为空，一不为空，将一重复上述步骤。
     */
    private Stack<Integer> stack_in;
    private Stack<Integer> stack_out;
    public offer_09() {
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }

    public void appendTail(int value) {
        stack_in.push(value);
    }

    public int deleteHead() {
        if (!stack_out.isEmpty()) return stack_out.pop();
        if (stack_in.isEmpty()) return -1;
        while (!stack_in.isEmpty()) {
            stack_out.push(stack_in.pop());
        }
        return stack_out.pop();
    }
}