package org.example;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        List<Task> loadedTasks = TaskPersistence.loadTasks();
        if (loadedTasks != null) {
            for (Task task : loadedTasks) {
                taskManager.addTask(task);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Adaugă taskuri manual");
        int taskId = 1;
        while (true) {
            System.out.print("Introduceti titlul taskului: ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Introduceti descrierea taskului: ");
            String description = scanner.nextLine();

            System.out.print("Introduceti deadline-ul taskului: ");
            String deadline = scanner.nextLine();

            System.out.print("Task-ul este completat (true/false): ");
            String completedInput = scanner.nextLine();
            boolean completed = false;

            if (completedInput.equalsIgnoreCase("true")) {
                completed = true;
            } else if (completedInput.equalsIgnoreCase("false")) {
                completed = false;
            } else {
                System.out.println("Input invalid! Se va considera task-ul incomplet.");
            }

            Task newTask = new Task(taskId++, title, description, deadline, completed);

            // Adăugăm taskul în manager
            taskManager.addTask(newTask);
            // Salvăm taskul în fișier JSON
            TaskPersistence.saveTask(newTask);

            System.out.println("Task adăugat și salvat cu succes!");

        }
        /*taskManager.addTask(new Task(1, "Cumparaturi", "Cumpara legume si fructe de la Mega", "2025-01-17", false));
        taskManager.addTask(new Task(2, "Proiect facultate", "Finalizeaza proiectul la MIP", "2025-01-28", false));
        taskManager.addTask(new RecurringTask(3, "Exercitii", "Rezolva exercitiile la AG", "2025-01-15", false, "Zilnic"));*/

        System.out.println("Toate taskurile: ");
        taskManager.showAllTasks();

        //taskManager.removeTask(2);

        taskManager.sortTasksByTitle();
        System.out.println("Toate taskurile sortate dupa titlu: ");
        taskManager.showAllTasks();

        taskManager.showTaskTypes();

        System.out.println("Toate taskurile incomplete: ");
        List<Task> incompleteTasks = taskManager.getIncompleteTasks();
        for (Task task : incompleteTasks) {
            System.out.println(task);
        }
        TaskPersistence.saveTasks(taskManager.getTasks());
        System.out.println("Task-urile au fost salvate!");
    }
}