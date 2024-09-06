import java.util.Arrays;

public class q4 {
    public static String canPermuteArrays(int[] a, int[] b, int k) {
        Arrays.sort(a);

        for (int num : b) {
            if (binarySearch(a, k - num)) {
                return "Yes";
            }
        }

        return "No";
    }

    public static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3};
        int[] b = {7, 8, 9};
        int k = 10;

        System.out.println(canPermuteArrays(a, b, k)); // Output: Yes
    }
}
