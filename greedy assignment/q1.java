import java.util.Arrays;

public class q1 {

    public static int minSumOfProducts(int[] arr1, int[] arr2, int k) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int minSum = 0;

        for (int i = 0; i < n; i++) {
            minSum += arr1[i] * arr2[n - i - 1];
        }

        for (int i = 0; i < n && k > 0; i++) {
            if (arr1[i] < arr2[n - i - 1]) {
                int diff = Math.min(k, (arr2[n - i - 1] - arr1[i]) / 2);
                arr1[i] += 2 * diff;
                k -= diff;
            } else if (arr1[i] > arr2[n - i - 1]) {
                int diff = Math.min(k, (arr1[i] - arr2[n - i - 1]) / 2);
                arr1[i] -= 2 * diff;
                k -= diff;
            }
        }

        minSum = 0;
        for (int i = 0; i < n; i++) {
            minSum += arr1[i] * arr2[n - i - 1];
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int k = 1;
        System.out.println(minSumOfProducts(arr1, arr2, k)); // Output: 23
    }
}
