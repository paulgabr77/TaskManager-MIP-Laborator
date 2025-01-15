import org.example.Task;
import org.example.TaskInterface;
import org.example.TaskManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        taskManager.addTask(new Task(1, "Cumparaturi", "Cumpara legume si fructe", "2025-01-17", false));
        taskManager.addTask(new Task(2, "Proiect facultate", "Finalizeaza proiectul", "2025-01-28", false));
    }
    @Test
    void testAddTask() {
        TaskInterface task = new Task(3, "Exercitii", "Rezolva exercitiile", "2025-01-15", false);
        taskManager.addTask(task);
        assertEquals(3, taskManager.getIncompleteTasks().size());
    }

    @Test
    void testRemoveTask() {
        taskManager.removeTask(1);
        assertEquals(1, taskManager.getIncompleteTasks().size());
    }

    @Test
    void testGetIncompleteTasks() {
        List<Task> incompleteTasks = taskManager.getIncompleteTasks();
        assertEquals(2, incompleteTasks.size());
    }

    @Test
    void testSortTasksByTitle(){
        taskManager.sortTasksByTitle();
        List<Task> tasks = taskManager.getIncompleteTasks();
        assertEquals("Cumparaturi", tasks.get(0).getTitlu());
    }
}
