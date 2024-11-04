import java.util.ArrayList;
import java.util.List;

// Interface representing an observer in the Observer design pattern
public interface TaskObserver {
    // Method to update the observer with the latest task information
    void update(Task task);

    // Static list to hold all registered observers
    static List<TaskObserver> observers = new ArrayList<>();

    // Method to add a new observer to the list
    static void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    // Method to notify all registered observers of a task update
    static void notifyObservers(Task task) {
        // Iterate through each observer and call their update method with the task
        for (TaskObserver observer : observers) {
            observer.update(task);
        }
    }
}
