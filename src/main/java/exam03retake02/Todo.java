package exam03retake02;

import java.util.Objects;

public class Todo implements Comparable<Todo> {

    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        this.text = text;
        if (priority > 5 || priority < 1) {
            throw new IllegalArgumentException("Invalid priority");
        }
        this.priority = priority;
        this.state = State.NON_COMPLETED;
    }

    public void complete() {
        this.state = State.COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }


    @Override
    public int compareTo(Todo todo) {
        return this.priority - todo.getPriority();
    }
}
