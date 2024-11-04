import java.util.List;

// Class responsible for displaying tasks in the to-do list
public class TaskView {
    // Method to display a list of tasks
    public void displayTasks(List<Task> tasks) {
        // Print a header for the to-do list
        System.out.println("To-Do List:");

        // Iterate over the provided list of tasks
        for (Task task : tasks) {
            // Print each task to the console
            System.out.println(task);
        }
    }
}
