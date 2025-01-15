package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;
    private boolean isValidTask(Task task) {
        return task.getTitlu() != null && !task.getTitlu().isEmpty() && task.getDeadline().matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public TaskManager() {
        tasks = new ArrayList<>();
    }
    public void addTask(Task task) {
        if(isValidTask(task)) {
            tasks.add(task);
            System.out.println("Sarcina a fost adaugata: " +  task.getTitlu());
        } else {
            System.out.println("Sarcina nu este valida!");
        }

    }
    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Sarcina cu ID-ul " + id + " a fost eliminata ");
    }
    public void showAllTasks() {
        System.out.println("Lista tuturor sarcinilor: ");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
    public void showTaskTypes() {
        for (TaskInterface task : tasks) {
            if (task instanceof AbstractTask) {
                System.out.println(((AbstractTask) task).getTaskType());
            }
        }
    }

    public void sortTasksByTitle(){
        tasks.sort(Comparator.comparing(TaskInterface::getTitlu));
    }
    public List<Task> getIncompleteTasks() {
        return tasks.stream().filter(task->!task.isCompleted()).collect(Collectors.toList());
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
