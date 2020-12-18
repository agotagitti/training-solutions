package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable {

    private List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    private  boolean nextStep() {
        if (!tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        while (nextStep()) {
            nextStep();
        }
    }

    public List<String> getTasks() {
        return tasks;
    }
}
