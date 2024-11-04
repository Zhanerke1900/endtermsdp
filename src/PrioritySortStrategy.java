import java.util.Comparator;
import java.util.List;

// Class that implements a sorting strategy based on task priority and urgency
public class PrioritySortStrategy implements SortStrategy {
    // Method to sort a list of tasks
    @Override
    public void sort(List<Task> tasks) {
        // Sort the tasks first by urgency (urgent tasks first), then by priority
        tasks.sort(Comparator.comparing(Task::isUrgent).reversed() // Urgent tasks first
                .thenComparing(Task::getPriority)); // Then by priority
    }
}
