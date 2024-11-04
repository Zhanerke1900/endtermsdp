import java.util.ArrayList;
import java.util.List;

public class ExternalTaskServiceAdapter {

    // Method to adapt a list of ExternalTask objects to Task objects
    public List<Task> adaptTasks(List<ExternalTask> externalTasks) {
        // Create a list to hold the adapted Task objects
        List<Task> adaptedTasks = new ArrayList<>();

        // Loop through each ExternalTask provided in the input list
        for (ExternalTask externalTask : externalTasks) {
            // Adapt fields to match Task's constructor
            String description = externalTask.getTitle(); // Get the title of the external task
            String priority = externalTask.getPriorityLevel(); // Get the priority level of the external task
            String deadline = externalTask.getDueDate(); // This should return a valid date string

            // Create a new Task object with the adapted data
            adaptedTasks.add(new Task(description, priority, deadline)); // Add the new Task to the adapted list
        }

        // Return the list of adapted Task objects
        return adaptedTasks;
    }
}
