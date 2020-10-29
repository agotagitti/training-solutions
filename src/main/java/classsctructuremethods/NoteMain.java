package classsctructuremethods;

public class NoteMain {

    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Jane Doe");
        note.setTopic("Java");
        note.setText("Testing the Note class");

        System.out.println("Name: " + note.getName());
        System.out.println("Topic: " + note.getTopic());
        System.out.println("Text: " + note.getText());

        System.out.println(note.getNoteText());
    }

}
