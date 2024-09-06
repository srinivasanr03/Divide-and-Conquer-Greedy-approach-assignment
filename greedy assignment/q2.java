import java.util.*;

class Activity {
    int start;
    int finish;
    
    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class q2 {
    public static List<Activity> maxActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
        List<Activity> selectedActivities = new ArrayList<>();
        
        if (activities.length == 0) {
            return selectedActivities;
        }
        
        selectedActivities.add(activities[0]);
        int lastSelectedIndex = 0;
        
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= activities[lastSelectedIndex].finish) {
                selectedActivities.add(activities[i]);
                lastSelectedIndex = i;
            }
        }
        
        return selectedActivities;
    }
    
    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(3, 8),
            new Activity(5, 9),
            new Activity(6, 10),
            new Activity(8, 11),
            new Activity(8, 12),
            new Activity(2, 13),
            new Activity(12, 14)
        };
        
        List<Activity> selectedActivities = maxActivities(activities);
        System.out.println("Maximum number of activities: " + selectedActivities.size());
        System.out.println("Selected activities:");
        for (Activity activity : selectedActivities) {
            System.out.println("Start: " + activity.start + ", Finish: " + activity.finish);
        }
    }
}
