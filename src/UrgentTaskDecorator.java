// Class that decorates a Task to make it urgent
public class UrgentTaskDecorator extends Task {
    private Task task; // The original task to be decorated

    // Constructor that takes a Task and marks it as urgent
    public UrgentTaskDecorator(Task task) {
        super(task.getDescription(), task.getPriority(), task.getDeadline());
        this.task = task; // Store the original task
        this.markAsUrgent(); // Automatically mark as urgent when wrapped
    }

    // Override the method to mark the original task as urgent
    @Override
    public void markAsUrgent() {
        task.markAsUrgent(); // Call the original task's method to mark it as urgent
    }

    // Override to always return true for urgency
    @Override
    public boolean isUrgent() {
        return true; // Always return true for the decorator, indicating urgency
    }

    // You may want to override toString() to reflect the urgency in output
    @Override
    public String toString() {
        return "[URGENT] " + task.toString(); // Prepend "[URGENT]" to the original task's string representation
    }
}
