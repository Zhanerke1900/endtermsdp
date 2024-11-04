public class TaskCompletionObserver implements TaskObserver {
    // This method is called when a task is updated (e.g., marked as completed)
    @Override
    public void update(Task task) {
        // Prints a message to the console indicating that a task has been completed
        System.out.println("Task completed: " + task.getDescription());
    }
}
