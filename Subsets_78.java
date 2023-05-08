import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 解法：
 *      回溯
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, result, path, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, LinkedList<Integer> path, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 包含 nums[i]
        path.offerLast(nums[index]);
        dfs(nums, result, path, index + 1);

        // 不包含 nums[i]
        path.pollLast();
        dfs(nums, result, path, index + 1);
    }
}
