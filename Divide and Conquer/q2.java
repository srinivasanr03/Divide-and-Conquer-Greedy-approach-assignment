public class q2 {
    public static void segregateNumbers(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            
            segregateNumbers(arr, low, mid); // Recursively segregate left half
            segregateNumbers(arr, mid + 1, high); // Recursively segregate right half
            
            merge(arr, low, mid, high); // Merge the two halves
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
        
        reverse(arr, left, mid); // Reverse the negative numbers in the left half
        reverse(arr, mid + 1, right - 1); // Reverse the negative numbers in the right half
        reverse(arr, left, right - 1); // Reverse the merged array
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
        // Output: -20 -4 -13 -5 19 11 7 3
    }
}
