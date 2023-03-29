import java.util.*;

public class carFleet_853 {
    /**
     * 853. 车队
     * 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
     *
     * 给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i 辆车的速度(单位是英里/小时)。
     *
     * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车 以相同的速度 紧接着行驶。此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
     *
     * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
     *
     * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
     *
     * 返回到达目的地的 车队数量 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
     * 输出：3
     *
     * 解法：
     *      对车队根据位置进行排列，从离目的地最近的车开始遍历，判断离目的地第二近的车会不会比第一的车先抵达重点，
     *      如果先抵达就汇成一个车队，速度将降为前车同速。
     *      使用栈结构实现，将离目的地最近的车入栈，判断第二近的车是否会超越前车，如果会超越则汇成一个车队，此时该车不入栈，
     *      因为与前车汇成一个车队，栈顶的车可以代表一个车队。如果不会超越则入栈，直到遍历结束。
     *      最后返回栈长度即可。
     */
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < position.length; i += 1) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        stack.add(position[position.length - 1]);
        for (int i = position.length - 2; i >= 0; i -= 1) {
            double front = (target - stack.peek()) * 1.0 / map.get(stack.peek());
            double back = (target - position[i]) * 1.0 / map.get(position[i]);
            if (front < back) { // the back car will overtake the front car.
                stack.add(position[i]);
            }
        }

        return stack.size();
    }
}
