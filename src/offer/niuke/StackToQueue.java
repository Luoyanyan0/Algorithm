package offer.niuke;

import java.util.Stack;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/10 15:31
 * @Description:用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**直接push进去Stack1
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 取出S1中所有的数放到S2中，再从S2中取出
     * @return
     */
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
