import org.example.RecurringTask;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecurringTaskTest {
    @Test
    public void testGetRecurrencePattern() {
        RecurringTask recurringTask = new RecurringTask(1, "Exercitii", "Rezolva exercitii", "2025-01-15", false, "Zilnic");
        assertEquals("Zilnic", recurringTask.getRecurrencePattern());
    }
    @Test
    public void testTaskType() {
        RecurringTask recurringTask = new RecurringTask(1, "Exercitii", "Rezolva exercitii", "2025-01-15", false, "Zilnic");
        assertEquals("Recurring task", recurringTask.getTaskType());
    }
}
