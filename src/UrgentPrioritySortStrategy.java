import java.util.Comparator;
import java.util.List;

// Class to sort tasks based on urgency and then by priority
public class UrgentPrioritySortStrategy implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        // Sort tasks first by urgency (urgent tasks first) and then by priority
        tasks.sort(Comparator.comparing(Task::isUrgent) // Check if the task is urgent
                .reversed() // Reverse the order to have urgent tasks first
                .thenComparing(Task::getPriority)); // Then sort by priority
    }
}
