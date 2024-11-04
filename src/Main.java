public class Main {
    public static void main(String[] args) {
        // Create an instance of TaskFactory to produce task objects
        TaskFactory taskFactory = new TaskFactory();

        // Get the singleton instance of ToDoList, which holds all tasks
        ToDoList toDoList = ToDoList.getInstance();

        // Create a new TaskView instance to manage the display of tasks
        TaskView taskView = new TaskView();

        // Create an instance of ExternalTaskServiceAdapter to handle external task adaptation
        ExternalTaskServiceAdapter externalTaskAdapter = new ExternalTaskServiceAdapter();

        // Create the TaskController, passing in the factory, list, view, and adapter
        TaskController controller = new TaskController(taskFactory, toDoList, taskView, externalTaskAdapter);

        // Start the task management application by invoking the run method of the controller
        controller.run();
    }
}
