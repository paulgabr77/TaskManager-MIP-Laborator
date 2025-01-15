package org.example;

public interface TaskInterface {
    int getId();
    String getTitlu();
    String getDescriere();
    String getDeadline();
    boolean isCompleted();
    void setCompleted(boolean completed);
}
