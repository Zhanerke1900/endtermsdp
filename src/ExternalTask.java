public class ExternalTask {
    private String title; // Title of the external task
    private String priorityLevel; // Priority level of the external task
    private String dueDate; // Due date of the task

    // Constructor to initialize the external task with title, priority level, and due date
    public ExternalTask(String title, String priorityLevel, String dueDate) {
        this.title = title; // Set the title
        this.priorityLevel = priorityLevel; // Set the priority level
        this.dueDate = dueDate; // Set the due date
    }

    // Getter method to retrieve the title of the task
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the priority level of the task
    public String getPriorityLevel() {
        return priorityLevel;
    }

    // Getter method to retrieve the due date of the task
    public String getDueDate() {
        return dueDate; // Ensure this method returns a date string
    }
}
