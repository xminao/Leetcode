import java.util.Map;
import java.util.Stack;

public class largestRectangleArea_84 {
    /**
     * 84. 柱状图中最大的矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 解法：
     *      维护一个栈，
     *      遍历柱状图，高度大于栈顶柱则入栈（key=当前索引，value=当前柱高度），
     *      高度小于栈顶柱，则代表栈顶的柱高无法向右延申，将栈顶柱弹出，直到高度大于栈顶柱，
     *      每次弹出栈顶柱，新柱的开始索引都为弹出栈顶的开始索引，因为新柱高度可以在那个索引开始延续。
     *      最后将栈清空。
     */
    private class Node {
        private int index;
        private int val;
        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
        public int getIndex() {
            return index;
        }
        public int getVal() {
            return val;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(-1, 0));
        int maxArea = 0;
        int curIndex = 0;
        while (curIndex < heights.length) {
            if (heights[curIndex] > stack.peek().getVal()) {
                stack.add(new Node(curIndex, heights[curIndex]));
            } else {
                int index = curIndex;
                while (heights[curIndex] < stack.peek().getVal()) {
                    int topArea = (curIndex - stack.peek().getIndex()) * stack.peek().getVal();
                    maxArea = Math.max(topArea, maxArea);
                    index = stack.peek().getIndex();
                    stack.pop();
                }
                stack.add(new Node(index, heights[curIndex]));
            }
            curIndex += 1;
        }

        while (!stack.isEmpty()) {
            int topArea = (curIndex - stack.peek().getIndex()) * stack.peek().getVal();
            maxArea = Math.max(topArea, maxArea);
            stack.pop();
        }

        return maxArea;
    }
}
