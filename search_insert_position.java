public class search_insert_position {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = lo + (hi - lo) / 2;
        while (lo <= hi) {
            if (nums[mid] > target) { // left area
                hi = mid - 1;
                mid = lo + (hi - lo) / 2;
            } else if (nums[mid] < target) { // right area
                lo = mid + 1;
                mid = lo + (hi - lo) / 2;
            } else {
                return mid;
            }
        }
        return hi;
    }
}
