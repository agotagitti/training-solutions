package introconstructors;

public class TaskMain {

    public static void main(String[] args) {

        Task task = new Task("Testing", "Java constructors");

        System.out.println(task.getTitle() + ", " + task.getDescription());

        task.start();

        System.out.println("Task starts: " + task.getStartDateTime());

        task.setDuration(60);

        System.out.println("Time for " + task.getTitle() + " is " + task.getDuration() + " minutes");

        task = new Task("Debugging", "'Task.java' debugging");

        System.out.println(task.getTitle() + ", " + task.getDescription());

        task.start();

        System.out.println("Task starts: " + task.getStartDateTime());

        task.setDuration(30);

        System.out.println("Time for " + task.getTitle() + " is " + task.getDuration() + " minutes");


    }
}
