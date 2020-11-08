package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption) {
        for (Todo done: todos) {
            if (done.getCaption().equals(caption)) {
                done.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (String caption: todosToFinish) {
            finishTodos(caption);
        }
    }

    public List<String> todosToFinish() {
        List<String> notDoneTodos = new ArrayList<>();
        for (Todo notDone: todos) {
            if (!notDone.isFinished()) {
                notDoneTodos.add(notDone.getCaption());
            }
        }
        return notDoneTodos;
    }

    public int numberOfFinishedTodos() {
        int doneTodos = 0;
        for (Todo done: todos) {
            if (done.isFinished()) {
                doneTodos += 1;
            }
        }
        return doneTodos;
    }

    @Override
    public String toString() {
        return todos.toString();
    }
}
