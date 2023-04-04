import java.util.Arrays;

public class minEatingSpeed_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int front = 0;
        int end = 0;
        int sum = 0;
        for (int i : piles) {
            sum += i;
            if (i > end) {
                end = i;
            }
        }
        front = (int) Math.ceil(sum * 1.0 / h);
        int[] nums = new int[end - front + 1];
        for (int i = 0; i < nums.length; i += 1) {
            nums[i] = front;
            front += 1;
        }

        int lo = 0;
        int hi = nums.length - 1;
        int min = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int time = helper(piles, nums[mid]);
            if (time > h) {
                lo = mid + 1;
            } else {
                min = nums[mid];
                hi = mid - 1;
            }
        }

        return min;
    }

    /*
     *  Returns elapsed time if eating k banana each hour.
     */
    private int helper(int[] piles, int k) {
        int sum = 0;
        for (int i : piles) {
            sum += Math.ceil(i * 1.0 / k);
        }
        return sum;
    }


}
