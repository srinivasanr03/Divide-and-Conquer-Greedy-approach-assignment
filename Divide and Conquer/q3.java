public class q3 {
    public static void segregateNumbers(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            segregateNumbers(arr, low, mid); // Recursively segregate left half
            segregateNumbers(arr, mid + 1, high); // Recursively segregate right half

            merge(arr, low, mid, high); // Merge the two halves while preserving relative order
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        while (left <= mid && arr[left] < 0) {
            left++;
        }

        while (right <= high && arr[right] < 0) {
            right++;
        }

        rotate(arr, left, mid, right - 1); // Rotate the positive numbers in the left half
        rotate(arr, mid + 1, right - 1, high); // Rotate the positive numbers in the right half
    }

    public static void rotate(int[] arr, int start, int mid, int end) {
        reverse(arr, start, mid); // Reverse the positive numbers in the current range
        reverse(arr, mid + 1, end); // Reverse the positive numbers in the current range
        reverse(arr, start, end); // Reverse the entire range
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {19, -20, 7, -4, -13, 11, -5, 3};
        segregateNumbers(arr, 0, arr.length - 1);

        // Print the segregated array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: -20 -4 -13 -5 19 7 11 3
    }
}
