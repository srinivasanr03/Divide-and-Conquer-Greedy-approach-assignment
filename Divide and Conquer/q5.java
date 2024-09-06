import java.util.Arrays;

public class q5 {
    public static boolean isIntersecting(int[][] intervals, int low, int high) {
        if (low >= high) {
            return false;
        }

        int mid = low + (high - low) / 2;

        return isIntersecting(intervals, low, mid) || isIntersecting(intervals, mid + 1, high)
                || checkIntersections(intervals, low, mid, high);
    }

    public static boolean checkIntersections(int[][] intervals, int low, int mid, int high) {
        for (int i = low; i <= mid; i++) {
            for (int j = mid + 1; j <= high; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[j][1] >= intervals[i][0]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        int[][] intervals2 = {{1, 3}, {7, 9}, {4, 6}, {10, 13}};

        Arrays.sort(intervals1, (a, b) -> a[0] - b[0]); // Sort intervals based on start times
        Arrays.sort(intervals2, (a, b) -> a[0] - b[0]); // Sort intervals based on start times

        System.out.println("Intervals 1 intersect: " + isIntersecting(intervals1, 0, intervals1.length - 1)); // Output: true
        System.out.println("Intervals 2 intersect: " + isIntersecting(intervals2, 0, intervals2.length - 1)); // Output: false
    }
}
