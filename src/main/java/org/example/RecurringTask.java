package org.example;

import java.time.LocalDate;

public class RecurringTask extends AbstractTask{
    private String recurrencePattern;

    public RecurringTask(int id, String titlu, String descriere, String deadline, boolean completed, String recurrencePattern) {
        super(id, titlu, descriere, deadline, completed);
        this.recurrencePattern = recurrencePattern;
    }
    public String getRecurrencePattern() {
        return recurrencePattern;
    }
    public void setRecurrencePattern(String recurrencePattern) {
        this.recurrencePattern = recurrencePattern;
    }

    @Override
    public String getTaskType() {
        return "Recurring task";
    }
    @Override
    public boolean isOverdue(String currentDate){
        return LocalDate.parse(getDeadline()).isBefore(LocalDate.parse(currentDate));
    }
    @Override
    public String toString() {
        return super.toString() + "RecurringTask [recurrencePattern=" + recurrencePattern + "]";
    }
}
