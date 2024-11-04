import java.util.ArrayList;
import java.util.List;

// Singleton class representing a to-do list that holds tasks
public class ToDoList {
    private static ToDoList instance; // Single instance of ToDoList
    private List<Task> tasks; // List to hold tasks

    // Private constructor to prevent instantiation from outside
    private ToDoList() {
        tasks = new ArrayList<>(); // Initialize the task list
    }

    // Static method to get the singleton instance of ToDoList
    public static ToDoList getInstance() {
        if (instance == null) { // Check if instance is already created
            instance = new ToDoList(); // Create a new instance if not
        }
        return instance; // Return the existing instance
    }

    // Method to add a new task to the to-do list
    public void addTask(Task task) {
        tasks.add(task); // Add the task to the list
    }

    // Method to retrieve the list of tasks
    public List<Task> getTasks() {
        return tasks; // Return the current list of tasks
    }

    // Method to remove a task from the to-do list
    public void removeTask(Task task) {
        tasks.remove(task); // Remove the specified task from the list
    }

    // Method to sort tasks based on a specified strategy
    public void sortTasks(SortStrategy strategy) {
        strategy.sort(tasks); // Sort the tasks using the provided strategy
    }

    // New method to replace an existing task with a modified or decorated version
    public void replaceTask(Task oldTask, Task newTask) {
        int index = tasks.indexOf(oldTask); // Find the index of the old task
        if (index != -1) { // If the old task is found
            tasks.set(index, newTask); // Replace it with the new task
        }
    }
}
