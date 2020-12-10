package week07d04;


import java.time.LocalDate;

public class Lab {

    private String title;
    private boolean completed;
    private LocalDate completedAt;

    public Lab(String title) {
        this.title = title;
        this.completed = false;
    }

    public Lab(String title, LocalDate completedAt) {
        this.title = title;
        complete(completedAt);
    }

    public void complete(LocalDate completedAt) {
        this.completedAt = completedAt;
        this.completed = true;
    }

    public void complete() {
        complete(LocalDate.now());
    }

    @Override
    public String toString() {
        return  "Title= " + title +
                ", completed= " + completed +
                ", completedAt= " + completedAt;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getCompletedAt() {
        return completedAt;
    }

}
