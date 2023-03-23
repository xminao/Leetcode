public class searchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int start = helper(nums, target, true);
        int end = helper(nums, target, false);
        return new int[]{start, end};
    }

    private int helper(int[] nums, int target, boolean isLeftBiased) {
        int index = -1;
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target > nums[mid]) { // search right area
                lo = mid + 1;
            } else if (target < nums[mid]) { // search left area
                hi = mid - 1;
            } else { // target equals mid number.
                index = mid;
                if (isLeftBiased) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return index;
    }
}