package org.example;

public abstract class AbstractTask implements TaskInterface{
    private int id;
    private String titlu;
    private String descriere;
    private String deadline;
    private boolean completed;



    public AbstractTask(int id, String titlu, String descriere, String deadline, boolean completed) {
        this.id = id;
        this.titlu = titlu;
        this.descriere = descriere;
        this.deadline = deadline;
        this.completed = completed;
    }

    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    @Override
    public String getTitlu() {
        return titlu;
    }
    @Override
    public String getDescriere() {
        return descriere;
    }
    @Override
    public String getDeadline() {
        return deadline;
    }
    @Override
    public boolean isCompleted() {
        return completed;
    }
    @Override
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    @Override
    public String toString() {
        return "Task [id=" + id + ", titlu=" + titlu + ", descriere=" + descriere +  ", deadline=" + deadline + ", completed=" + completed + "]";
    }
    public abstract boolean isOverdue(String currentDate);
    public abstract String getTaskType();
}
