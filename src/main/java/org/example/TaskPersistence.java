package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskPersistence {
    private static final String FILE_PATH = "tasks.json";

    public static void saveTasks(List<Task> tasks) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            objectMapper.writeValue(file, tasks);
            System.out.println("Taskurile au fost salvate cu succes.");
        } catch (IOException e) {
            System.err.println("Eroare la salvarea taskurilor!" + e.getMessage());
        }
    }
    public static void saveTask(Task task) {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        try {
            List<Task> tasks = loadTasks();
            tasks.add(task);
            saveTasks(tasks);
            objectMapper.writeValue(file, tasks);
            System.out.println("Taskul a fost salvat cu succes.");
        } catch (IOException e) {
            System.err.println("Eroare la salvarea taskului!" + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Task> tasks = new ArrayList<>();
        try (InputStream inputStream = TaskPersistence.class.getClassLoader().getResourceAsStream(FILE_PATH)) {
            if (inputStream == null) {
                System.out.println("Fișierul tasks.json nu a fost găsit!");
                return tasks;
            }
            tasks = objectMapper.readValue(inputStream, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            System.err.println("Eroare la incarcarea taskurilor!" + e.getMessage());
        }
        return tasks;
    }
}