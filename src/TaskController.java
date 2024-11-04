import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskController {
    private TaskFactory taskFactory; // Factory to create tasks
    private ToDoList toDoList; // The list that holds all tasks
    private TaskView taskView; // View to display tasks to the user
    private ExternalTaskServiceAdapter externalTaskAdapter; // Adapter to handle external tasks

    // Minimum date for task deadlines
    private static final LocalDate MIN_DATE = LocalDate.parse("2024-11-04");

    public TaskController(TaskFactory taskFactory, ToDoList toDoList, TaskView taskView, ExternalTaskServiceAdapter externalTaskAdapter) {
        this.taskFactory = taskFactory;
        this.toDoList = toDoList;
        this.taskView = taskView;
        this.externalTaskAdapter = externalTaskAdapter; // Initialize the external task adapter
    }

    // Main loop to run the task management application
    public void run() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        boolean exit = false; // Flag to control the application loop

        while (!exit) {
            // Display options to the user
            System.out.println("1. Add Task\n2. Complete Task\n3. View Tasks\n4. Sort Tasks by Priority\n5. Mark Task as Urgent\n6. Remove Task\n7. Import External Tasks\n8. Exit");
            int choice = scanner.nextInt(); // Get user choice
            scanner.nextLine(); // Consume newline character

            // Handle user choice
            switch (choice) {
                case 1:
                    addTask(scanner); // Call method to add a task
                    break;
                case 2:
                    completeTask(scanner); // Call method to complete a task
                    break;
                case 3:
                    viewTasks(); // Call method to view all tasks
                    break;
                case 4:
                    sortTasks(); // Call method to sort tasks by priority
                    break;
                case 5:
                    markTaskAsUrgent(scanner); // Call method to mark a task as urgent
                    break;
                case 6:
                    removeTask(scanner); // Call method to remove a task
                    break;
                case 7:
                    importExternalTasks(); // Call method to import external tasks
                    break;
                case 8:
                    exit = true; // Set exit flag to true to terminate the loop
                    break;
                default:
                    System.out.println("Invalid option. Try again."); // Handle invalid input
            }
        }
    }

    // Method to add a new task
    private void addTask(Scanner scanner) {
        System.out.print("Enter description: ");
        String description = scanner.nextLine(); // Get task description
        System.out.print("Enter priority: ");
        String priority = scanner.nextLine(); // Get task priority
        System.out.print("Enter deadline (yyyy-MM-dd): ");
        String deadlineInput = scanner.nextLine(); // Get task deadline as string

        try {
            LocalDate deadline = LocalDate.parse(deadlineInput); // Parse the date input

            // Validate the date against the minimum date
            if (deadline.isBefore(MIN_DATE)) {
                System.out.println("The deadline must be after " + MIN_DATE + ". Task not added.");
                return; // Exit if the date is not valid
            }

            // Create a new task if the date is valid
            Task task = taskFactory.createTask(description, priority, deadlineInput);
            toDoList.addTask(task); // Add task to the to-do list
            System.out.println("Task added: " + task);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd."); // Handle invalid date format
        }
    }

    // Method to complete an existing task
    private void completeTask(Scanner scanner) {
        System.out.print("Enter task description to complete: ");
        String description = scanner.nextLine(); // Get task description
        Task taskToComplete = findTaskByDescription(description); // Find the task
        if (taskToComplete != null) {
            taskToComplete.complete(); // Mark task as completed
            System.out.println("Task completed: " + taskToComplete);
        } else {
            System.out.println("Task not found."); // Handle task not found
        }
    }

    // Method to view all tasks
    private void viewTasks() {
        taskView.displayTasks(toDoList.getTasks()); // Display tasks using the view
    }

    // Method to sort tasks by priority
    private void sortTasks() {
        toDoList.sortTasks(new PrioritySortStrategy()); // Sort tasks
        System.out.println("Tasks sorted by priority."); // Confirmation message
    }

    // Method to mark a task as urgent
    private void markTaskAsUrgent(Scanner scanner) {
        System.out.print("Enter task description to mark as urgent: ");
        String description = scanner.nextLine(); // Get task description
        Task taskToMark = findTaskByDescription(description); // Find the task
        if (taskToMark != null) {
            UrgentTaskDecorator urgentTask = new UrgentTaskDecorator(taskToMark); // Create urgent task
            toDoList.replaceTask(taskToMark, urgentTask); // Replace the task in the to-do list
            System.out.println("Marked as urgent: " + urgentTask);
        } else {
            System.out.println("Task not found."); // Handle task not found
        }
    }

    // Method to remove a task
    private void removeTask(Scanner scanner) {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine(); // Get task description
        Task taskToRemove = findTaskByDescription(description); // Find the task
        if (taskToRemove != null) {
            toDoList.removeTask(taskToRemove); // Remove the task from the list
            System.out.println("Task removed: " + taskToRemove);
        } else {
            System.out.println("Task not found."); // Handle task not found
        }
    }

    // Method to import external tasks
    private void importExternalTasks() {
        // Example list of external tasks
        List<ExternalTask> externalTasks = new ArrayList<>();
        externalTasks.add(new ExternalTask("External Task 1", "3", "2024-12-01")); // Example external task 1
        externalTasks.add(new ExternalTask("External Task 2", "1", "2024-11-15")); // Example external task 2

        // Adapt external tasks to Task objects
        List<Task> tasks = externalTaskAdapter.adaptTasks(externalTasks);

        // Add the adapted tasks to the main ToDoList
        for (Task task : tasks) {
            toDoList.addTask(task); // Add each adapted task to the to-do list
            System.out.println("Imported Task: " + task); // Confirmation message
        }
    }

    // Method to find a task by its description
    private Task findTaskByDescription(String description) {
        for (Task task : toDoList.getTasks()) { // Iterate through all tasks
            if (task.getDescription().equalsIgnoreCase(description)) { // Check for matching description
                return task; // Return the matching task
            }
        }
        return null; // Return null if no matching task is found
    }
}
