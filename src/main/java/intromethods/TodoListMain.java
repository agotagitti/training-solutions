package intromethods;

import java.util.Arrays;
import java.util.List;

public class TodoListMain {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        for (int i = 1; i < 6; i++) {
            todoList.addTodo("todo" + i);
            todoList.addTodo("todo" + i);
        }
        System.out.println(todoList.todosToFinish());

        todoList.finishTodos("todo2");
        System.out.println("Finished todos: " + todoList.numberOfFinishedTodos());

        List<String> finishAll = Arrays.asList("todo1", "todo3");

        todoList.finishAllTodos(finishAll);

        System.out.println("Unfinished todos: " + todoList.todosToFinish());
        System.out.println("Finished todos: " + todoList.numberOfFinishedTodos());

        System.out.println(todoList);

    }
}
