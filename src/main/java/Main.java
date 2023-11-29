public class Main {

    /**
     * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a>
     */
    public static int[] search(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;

        int left = 0;
        int high = nums.length;
        int mid;
        while (left < high)
            if (nums[mid = left + (high - left) / 2] >= target)
                high = mid;
            else
                left = mid + 1;

        if (left == nums.length || nums[left] != target)
            return res;
        res[0] = res[1] = left;
        for (int i = left; i < nums.length; i++)
            if (nums[i] == target)
                res[1] = i;
            else break;


        return res;
    }

    /**
     * <a href="https://leetcode.com/problems/multiply-strings/">Multiply strings</a>
     */
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || "0".equals(num1) || "0".equals(num2) || num1.isEmpty() || num2.isEmpty() || !num1.matches("[0-9]+") || !num2.matches("[0-9]+") || (num1.startsWith("0") && num1.length() > 1) || (num2.startsWith("0") && num2.length() > 1))
            return "0";
        if ("1".equals(num1))
            return num2;
        if ("1".equals(num2))
            return num1;
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                arr[i + j + 1] += a * b;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = arr[0] == 0 ? 1 : 0; i < arr.length; i++)
            ans.append(arr[i]);
        return ans.toString();
    }

    /**
     * <a href="https://leetcode.com/problems/powx-n/">Pow(x, n)</a>
     */
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n /= 2;
        }

        if (n < 0) {
            n = Math.abs(n);
            x = 1 / x;
        }

        double result = 1;

        for (; n > n / 2; n /= 2, x *= x)
            if (n % 2 == 1)
                result *= x;

        return result;
    }
}