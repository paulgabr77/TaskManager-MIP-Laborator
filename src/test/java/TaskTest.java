
import org.example.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    void testIsOverdue(){
        Task task = new Task(1, "Cumparaturi", "Cumpara legume si fructe", "2025-01-15", false);
        assertTrue(task.isOverdue("2025-01-16"));
        assertFalse(task.isOverdue("2025-01-14"));
    }
    @Test
    void testMarkAsCompleted(){
        Task task = new Task(1, "Cumparaturi", "Cumpara legume si fructe", "2025-01-15", false);
        task.setCompleted(true);
        assertTrue(task.isCompleted());
    }
}
