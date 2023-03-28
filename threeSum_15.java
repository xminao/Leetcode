import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (!(i > 0 && nums[i] == nums[i - 1])) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        l += 1;
                        while (nums[l] == nums[l - 1] && l < r) {
                            l += 1;
                        }
                    } else if (sum > 0) { // move the right pointer to decrease sum.
                        r -= 1;
                    } else { // move the left pointer to increase the sum.
                        l += 1;
                    }
                }
            }
        }
        return result;
    }
}
