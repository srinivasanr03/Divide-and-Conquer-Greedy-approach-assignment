import java.util.*;

public class q5 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals based on end times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int end = intervals[0][1];

        // Iterate through intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the previous one, remove it
            if (intervals[i][0] < end) {
                count++;
            } else {
                // Update the end time of the last non-overlapping interval
                end = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Minimum number of intervals to remove: " + eraseOverlapIntervals(intervals)); // Output: 1
    }
}
