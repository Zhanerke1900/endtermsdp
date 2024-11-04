import java.util.List;

// Interface that defines a sorting strategy for tasks
public interface SortStrategy {
    // Method to sort a list of tasks
    void sort(List<Task> tasks);
}
