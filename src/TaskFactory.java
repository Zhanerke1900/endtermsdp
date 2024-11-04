public class TaskFactory {
    // Method to create a new Task object with the given parameters
    public Task createTask(String description, String priority, String deadline) {
        // Instantiate and return a new Task object using the provided description, priority, and deadline
        return new Task(description, priority, deadline);
    }
}
