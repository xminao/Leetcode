import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 解法：
 *      回溯
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int[] visited = new int[nums.length];
        dfs(nums, result, path, visited);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, LinkedList<Integer> path, int[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i += 1) {
            if (visited[i] == 1) continue;
            // 做选择
            visited[i] = 1;
            path.offerLast(nums[i]);
            dfs(nums, result, path, visited);
            // 撤销选择
            visited[i] = 0;
            path.pollLast();

        }
    }



}
