package exam03retake02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {

    List<Todo> todos = new ArrayList<>();


    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public int getNumberOfItemsLeft() {
        int leftTodos = 0;
        for (Todo actualTodo : todos) {
            if (actualTodo.getState() == State.NON_COMPLETED) {
                leftTodos++;
            }
        }
        return leftTodos;
    }

    public List<String> getMostImportantTodosText() {
        List<String> mostImportant = new ArrayList<>();
        int levelOfImportance = 5;
        for (Todo actualTodo : todos) {
            if (actualTodo.getPriority() < levelOfImportance) {
                levelOfImportance = actualTodo.getPriority();
            }
        }
        for (Todo actualTodo : todos) {
            if (actualTodo.getPriority() == levelOfImportance) {

                mostImportant.add(actualTodo.getText());
            }
        }
        return mostImportant;
    }

    public void deleteCompleted() {
        List<Todo> todosToRemove = new ArrayList<>();
        for (Todo actualTodo : todos) {
            if (actualTodo.getState() == State.COMPLETED) {
                todosToRemove.add(actualTodo);
            }
        }
        todos.removeAll(todosToRemove);
    }
}
