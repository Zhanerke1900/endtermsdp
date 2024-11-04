public class Task {
    private String description;  // Description of the task
    private String priority;      // Priority level of the task
    private String deadline;      // Deadline as String (representing a date)
    private boolean completed;    // Flag indicating if the task is completed
    private boolean urgent;       // Flag indicating if the task is urgent

    // Constructor to initialize a task with description, priority, and deadline
    public Task(String description, String priority, String deadline) {
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.completed = false;  // Task is initially not completed
        this.urgent = false;     // Default to not urgent
    }

    public String getDescription() {
        return description; // Returns the description of the task
    }

    public String getPriority() {
        return priority; // Returns the priority of the task
    }

    public String getDeadline() {
        return deadline; // Returns the deadline of the task
    }

    public boolean isCompleted() {
        return completed; // Returns true if the task is completed
    }

    public boolean isUrgent() {
        return urgent; // Returns true if the task is marked as urgent
    }

    // Marks the task as completed
    public void complete() {
        this.completed = true; // Set the completed flag to true
    }

    // Method to mark the task as urgent
    public void markAsUrgent() {
        this.urgent = true; // Set the urgent flag to true
    }

    // Provides a string representation of the task, including its urgency, status, and deadline
    @Override
    public String toString() {
        return (urgent ? "[URGENT] " : "") + description + " [" + priority + "] - "
                + (completed ? "Completed" : "Pending") + " - Deadline: " + deadline;
    }
}
