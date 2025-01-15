package org.example;
import java.time.LocalDate;

public class Task extends AbstractTask {

    public Task() {
        super(0, "","","",false);
    }

    public Task(int id, String titlu, String descriere, String deadline, boolean completed) {
        super(id, titlu, descriere, deadline, completed);
    }
    @Override
    public boolean isOverdue(String currentDate){
        return LocalDate.parse(getDeadline()).isBefore(LocalDate.parse(currentDate));
    }
    @Override
    public String getTaskType() {
        return "Standard Task";
    }
}
