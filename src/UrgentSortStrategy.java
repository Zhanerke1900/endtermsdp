import java.util.Comparator;
import java.util.List;

// Class to sort tasks based on their urgency
public class UrgentSortStrategy implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        // Sort tasks with urgent tasks appearing first
        tasks.sort(Comparator.comparing(Task::isUrgent) // Check if the task is urgent
                .reversed() // Reverse the order to have urgent tasks first
                .thenComparing(Task::getPriority)); // Then sort by priority
    }
}
