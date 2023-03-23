
public class SumSwap {
    public static int[] findSwapValues(int[] array1, int[] array2) {
        int sum_1 = 0;
        int sum_2 = 0;
        for (int i : array1) {
            sum_1 += i;
        }
        for (int i : array2) {
            sum_2 += i;
        }

        int[] arr = {};
        for (int i : array1) {
            for (int k : array2) {
                if (sum_1 - i + k == sum_2 - k + i) {
                    arr = new int[2];
                    arr[0] = i;
                    arr[1] = k;
                }
            }
        }

        return arr;
    }

    public static void main(String args[]) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        int[] out = findSwapValues(a, b);
        for (int i : out) {
            System.out.println(i);
        }
    }
}
