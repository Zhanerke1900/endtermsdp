public abstract class TaskDecorator extends Task {
    protected Task task; // The task that this decorator wraps

    // Constructor that takes a Task and initializes the decorated task
    public TaskDecorator(Task task) {
        super(task.getDescription(), task.getPriority(), task.getDeadline()); // Call the constructor of Task with the decorated task's details
        this.task = task; // Set the task to the provided task
    }

    // Override toString to provide the string representation of the decorated task
    @Override
    public String toString() {
        return task.toString(); // Return the string representation of the wrapped task
    }
}
